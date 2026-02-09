# Ghid de Deployment - GENERATIVA AI Platform

## 📋 Prezentare Generală

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│   GitHub        │────▶│   Auto-Deploy   │────▶│   Production    │
│   Repository    │     │   (push-based)  │     │   Environment   │
└─────────────────┘     └─────────────────┘     └─────────────────┘
                                                       │
                              ┌────────────────────────┼────────────────────────┐
                              │                        │                        │
                              ▼                        ▼                        ▼
                        ┌─────────┐              ┌─────────┐              ┌─────────┐
                        │ Vercel  │              │ Railway │              │ Resend  │
                        │Frontend │              │ Backend │              │  Email  │
                        │         │              │+Postgres│              │  API    │
                        └─────────┘              └─────────┘              └─────────┘
```

## 🚀 Arhitectura Curentă (Februarie 2026)

### Branch Strategy

| Branch | Deploy Target | URL |
|--------|--------------|-----|
| `main` | Vercel Prod + Railway Prod | https://diginest-ai-platform.vercel.app |
| `staging` | Vercel Preview | Preview URL generat automat |

> **Regula**: Frontend nou (GENERATIVA) se dezvoltă pe `staging`. Backend merge pe `main` (Railway ascultă doar `main`).

### Services

| Service | Platform | URL | Auto-Deploy |
|---------|----------|-----|-------------|
| Frontend | Vercel | https://diginest-ai-platform.vercel.app | ✅ push pe main |
| Frontend Preview | Vercel | *generat la push* | ✅ push pe staging |
| Backend API | Railway | https://diginest-backend-production.up.railway.app | ✅ push pe main |
| Database | Railway (PostgreSQL) | Private + metro.proxy.rlwy.net:32252 | N/A |
| Email | Resend HTTP API | https://api.resend.com/emails | N/A |
| Hosting/DNS | Hosterion (cPanel) | generativa.ro | Manual |

## 🔧 Vercel Setup (Frontend)

### Configurare

```
Framework Preset: Astro
Root Directory: frontend
Build Command: npm run build
Output Directory: dist
Install Command: npm install
```

### Environment Variables

```
PUBLIC_SITE_URL=https://generativa.ro
PUBLIC_API_URL=https://diginest-backend-production.up.railway.app
```

## 🚂 Railway Setup (Backend)

### Configurare

```
Root Directory: /backend
Builder: Nixpacks (auto-detectează Java 21 + Maven)
Branch: main
Source: IleanaOneata/diginest-ai-platform
```

### PostgreSQL

Adăugat ca addon în Railway project. Conectat automat.

### Environment Variables (Complet - Februarie 2026)

```bash
# Spring Boot
SPRING_PROFILES_ACTIVE=prod

# Database (PostgreSQL pe Railway)
DATABASE_URL=jdbc:postgresql://metro.proxy.rlwy.net:32252/railway
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=RHiVbAXqsXtuIoqvsEMXPopcYjcvSARB

# Email - Resend HTTP API (SMTP blocat de Railway!)
# MAIL_PASSWORD este reutilizat ca Resend API key
MAIL_HOST=smtp.resend.com
MAIL_PORT=465
MAIL_USERNAME=resend
MAIL_PASSWORD=re_SSiJmdXw_MUuf9eTTqgmWjoUDJPDmwFzo
MAIL_PROTOCOL=smtps
MAIL_SSL_ENABLE=true
MAIL_STARTTLS_ENABLE=false

# App email settings
EMAIL_FROM=contact@generativa.ro
EMAIL_ADMIN=contact@generativa.ro
EMAIL_ENABLED=true
```

### ⚠️ Railway Constraints

1. **SMTP blocat** — Railway blochează porturile 25, 465, 587 outbound. Email-ul funcționează DOAR prin Resend HTTP API (port 443).
2. **Private networking** — `*.railway.internal` NU funcționează cu `railway up` CLI deploys. Folosește URL-uri publice.
3. **DATABASE_URL** — Trebuie prefix `jdbc:postgresql://`. URL public: `metro.proxy.rlwy.net:32252`.
4. **NO Maven wrapper** — Nu adăuga `mvnw`. Nixpacks folosește `mise` care gestionează Java/Maven.
5. **Build time** — ~2-3 minute (Maven build + JVM start).

### Railway CLI

```bash
# Install
npm install -g @railway/cli

# Login
railway login

# Link project (din folderul backend)
cd backend
railway link

# Manage variables
railway variables                           # List all
railway variables set KEY=VALUE             # Set one
railway logs --lines 20                     # View logs
railway status                              # Check status
```

## 📧 Resend Email Setup

### Cont

- **Provider**: Resend.com (free tier, 3000 emails/lună)
- **Login**: GitHub OAuth (IleanaOneata)
- **Regiune**: Ireland (eu-west-1)

### Domeniu Verificat: generativa.ro

DNS records adăugate în **cPanel → Zone Editor**:

| Type | Name | Value | TTL |
|------|------|-------|-----|
| TXT | `resend._domainkey.generativa.ro` | DKIM key | 14400 |
| MX | `send.generativa.ro` | `feedback-smtp.eu-west-1.amazonses.com` | 14400 (priority 10) |
| TXT | `send.generativa.ro` | `v=spf1 include:amazonses.com ~all` | 14400 |

### Cum Funcționează

EmailService trimite email-uri prin POST la `https://api.resend.com/emails` cu Bearer token (API key stocat în `MAIL_PASSWORD`).

## 🔄 Deployment Flow

### Automatic (Standard)

1. Push pe `main` → Railway auto-deploy backend + Vercel auto-deploy frontend prod
2. Push pe `staging` → Vercel auto-deploy frontend preview

### Manual (Emergency)

```bash
# Frontend
cd frontend
npx vercel --prod

**Backend:**
> ⚠️ **NU folosi `railway up` (CLI)!** Railway are Root Directory setat la `/backend`, dar CLI-ul nu gestionează corect monorepo-urile. Rezultatul: eroarea `Could not find root directory: /backend`. În plus, fișierul `nul` din rădăcina repo-ului (nume rezervat pe Windows) cauzează crash cu `Incorrect function. (os error 1)`.

**Singura metodă funcțională pentru backend:**
```bash
# Push pe main → Railway auto-deploy via GitHub
git push origin main
```

~~`railway up` — NU FUNCȚIONEAZĂ cu monorepo~~

## ✅ Verification Checklist

După deployment, verifică:

- [ ] Health endpoint: `curl https://diginest-backend-production.up.railway.app/actuator/health` → `{"status":"UP"}`
- [ ] Contact form: trimite test, verifică email primit
- [ ] Railway logs: `railway logs --lines 20` — fără erori
- [ ] Homepage loads (RO & EN)
- [ ] Language switch works
- [ ] Mobile responsive
- [ ] Mesajul de succes dispare după 5 secunde

## 🐛 Troubleshooting

### Email-urile nu se trimit

1. Verifică Railway logs: `railway logs --lines 20`
2. Verifică Resend dashboard → Emails (delivery status)
3. Verifică că `EMAIL_ENABLED=true` și `MAIL_PASSWORD` e setat
4. **NU încerca SMTP** — e blocat de Railway

### Railway deploy eșuează

1. Verifică Root Directory: trebuie `/backend`
2. Verifică branch: trebuie `main`
3. Verifică logs de build în Railway dashboard

### Health endpoint DOWN

1. Verifică `management.health.mail.enabled=false` în application.yml
2. Verifică DATABASE_URL (prefix `jdbc:postgresql://`)
3. Verifică PostgreSQL addon e activ

### Railway deploy fails cu "Could not find root directory"

**Cauză**: Folosești `railway up` (CLI). CLI-ul NU suportă Root Directory config pentru monorepo-uri.

**Soluție**: Deploy DOAR prin `git push origin main`. Railway auto-deploy via GitHub funcționează perfect.

### CORS errors

1. Verifică `CORS_ORIGINS` include frontend domain
2. Check browser console for exact error

## 📊 Costs Estimate

| Service | Free Tier | Paid (if needed) |
|---------|-----------|------------------|
| Vercel | 100GB bandwidth | $20/mo Pro |
| Railway | $5 credit/mo | ~$5-10/mo |
| Resend | 3000 emails/mo | $20/mo (50k emails) |
| Domain (generativa.ro) | - | ~$10/year |
| Hosterion Hosting | Current plan | Current plan |
| **Total** | **~$0-5/mo** | **~$55-60/mo** |

---

*Ultima actualizare: Februarie 2026*

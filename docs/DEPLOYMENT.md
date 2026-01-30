# Ghid de Deployment - Diginest AI Platform

## 📋 Prezentare Generală

```
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│   GitHub        │────▶│   CI/CD         │────▶│   Production    │
│   Repository    │     │   (Actions)     │     │   Environment   │
└─────────────────┘     └─────────────────┘     └─────────────────┘
                                                       │
                              ┌────────────────────────┼────────────────────────┐
                              │                        │                        │
                              ▼                        ▼                        ▼
                        ┌─────────┐              ┌─────────┐              ┌─────────┐
                        │ Vercel  │              │ Railway │              │Cloudflare│
                        │Frontend │              │ Backend │              │   DNS   │
                        └─────────┘              └─────────┘              └─────────┘
```

## 🚀 Prima Configurare

### 1. GitHub Repository

```bash
# Inițializează repository-ul
cd "AI Agents Platform"
git init
git add .
git commit -m "Initial commit: Diginest AI Platform MVP"
git branch -M main
git remote add origin https://github.com/your-org/diginest-ai-platform.git
git push -u origin main
```

### 2. Vercel Setup (Frontend)

1. **Conectare la Vercel:**
   - Du-te la [vercel.com](https://vercel.com)
   - Sign in cu GitHub
   - "Add New" → "Project"
   - Selectează repository-ul `diginest-ai-platform`

2. **Configurare:**
   ```
   Framework Preset: Astro
   Root Directory: frontend
   Build Command: npm run build
   Output Directory: dist
   Install Command: npm install
   ```

3. **Environment Variables:**
   ```
   PUBLIC_SITE_URL=https://diginest.ai
   PUBLIC_API_URL=https://api.diginest.ai  # Când backend-ul e gata
   ```

4. **Domain Setup:**
   - Settings → Domains → Add `diginest.ai`
   - Follow DNS instructions

### 3. Railway Setup (Backend)

1. **Conectare la Railway:**
   - Du-te la [railway.app](https://railway.app)
   - Sign in cu GitHub
   - "New Project" → "Deploy from GitHub repo"

2. **Configurare:**
   ```
   Root Directory: backend
   Builder: Nixpacks (auto-detectează Maven)
   ```

3. **Add PostgreSQL:**
   - În proiect → "New" → "Database" → "PostgreSQL"
   - Railway va crea `DATABASE_URL` automat

4. **Environment Variables:**
   ```
   SPRING_PROFILES_ACTIVE=prod
   DATABASE_URL=${{Postgres.DATABASE_URL}}
   DATABASE_USERNAME=${{Postgres.PGUSER}}
   DATABASE_PASSWORD=${{Postgres.PGPASSWORD}}
   CORS_ORIGINS=https://diginest.ai
   EMAIL_ENABLED=true
   EMAIL_FROM=noreply@diginest.ai
   EMAIL_ADMIN=contact@diginest.ai
   MAIL_HOST=smtp.resend.com
   MAIL_PORT=587
   MAIL_USERNAME=resend
   MAIL_PASSWORD=re_xxxxx  # Get from Resend
   ```

5. **Custom Domain:**
   - Settings → Domains → Add `api.diginest.ai`

### 4. Cloudflare DNS Setup

1. **Add Domain:**
   - DNS → Add record

2. **Records:**
   ```
   Type: CNAME
   Name: @
   Content: cname.vercel-dns.com  # From Vercel
   Proxy: DNS only (grey cloud)

   Type: CNAME
   Name: www
   Content: cname.vercel-dns.com
   Proxy: DNS only

   Type: CNAME
   Name: api
   Content: your-app.up.railway.app  # From Railway
   Proxy: DNS only
   ```

3. **SSL/TLS:**
   - SSL/TLS → Full (strict)

### 5. GitHub Secrets

În GitHub repo → Settings → Secrets → Actions:

```
VERCEL_TOKEN=xxx
VERCEL_ORG_ID=xxx
VERCEL_PROJECT_ID=xxx
RAILWAY_TOKEN=xxx
```

## 🔄 Deployment Flow

### Automatic (Recommended)

1. Push to `main` branch
2. GitHub Actions triggered
3. Build & test
4. Deploy to Vercel/Railway

### Manual (Emergency)

**Frontend:**
```bash
cd frontend
npm install -g vercel
vercel --prod
```

**Backend:**
```bash
cd backend
railway up
```

## ✅ Verification Checklist

După deployment, verifică:

- [ ] Homepage loads (RO & EN)
- [ ] Language switch works
- [ ] All pages accessible
- [ ] Contact form shows (no backend yet = simulated)
- [ ] Mobile responsive
- [ ] SSL certificate valid
- [ ] Lighthouse score > 90

## 🐛 Troubleshooting

### Frontend nu se încarcă

1. Check Vercel deployment logs
2. Verify environment variables
3. Check build output

### Backend 500 errors

1. Check Railway logs
2. Verify DATABASE_URL
3. Check environment variables

### CORS errors

1. Verify `CORS_ORIGINS` includes frontend domain
2. Check browser console for exact error
3. Restart backend after env change

## 📊 Costs Estimate

| Service | Free Tier | Paid (if needed) |
|---------|-----------|------------------|
| Vercel | 100GB bandwidth | $20/mo Pro |
| Railway | $5 credit/mo | ~$5-10/mo |
| Cloudflare | Unlimited | - |
| Domain | - | ~$10/year |
| **Total** | **~$0-5/mo** | **~$35-40/mo** |

---

*Ultima actualizare: Ianuarie 2025*

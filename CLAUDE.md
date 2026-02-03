# GENERATIVA - AI Agents Platform

## 🚨 STATUS CURENT (Februarie 2026)

### Branch-uri Git
| Branch | Scop | URL |
|--------|------|-----|
| `main` | Producție (Diginest vechi) | https://diginest-ai-platform.vercel.app |
| `staging` | **ACTIV** - Rebranding GENERATIVA | Preview URL la push |

### Ce s-a făcut în această sesiune:
1. ✅ Rebranding complet Diginest → GENERATIVA
2. ✅ Logo SVG nou creat cu gradient cyan→purple și noduri animate
3. ✅ Culori actualizate în tot site-ul
4. ✅ Branch `staging` creat pentru teste
5. ✅ `noindex` automat pentru staging/preview URLs

### Următorii pași:
1. [ ] Commit și push pe `staging`
2. [ ] Testare pe preview URL Vercel
3. [ ] Finisare logo și design
4. [ ] Achiziție domeniu generativa.ro
5. [ ] Merge în `main` când e gata

---

## 🎯 CONTEXT BUSINESS & PRODUS

### Obiectivul Principal
Construirea unui site de prezentare profesional pentru o agenție de AI Agents, similar ca funcționalitate și impact cu https://www.inflate.agency/

### Obiective de Business la Lansare
- Generarea de lead-uri calificate
- Susținerea vânzărilor prin contact direct
- Poziționarea brandului ca expert AI în România
- Construirea încrederii pentru decidenți B2B

### Public Țintă
- **Tip**: B2B
- **Companii**: SME-uri din România și UE
- **Decidenți**: CEO, CTO, Head of Marketing
- **Nivel de înțelegere AI**: mediu
- **Mesajul**: clar, business-oriented, fără jargon excesiv, orientat pe rezultate concrete

---

## 🎨 BRANDING - GENERATIVA

### Identitate Vizuală
- **Nume**: GENERATIVA
- **Domeniu țintă**: generativa.ro (de achiziționat)
- **Tagline RO**: "Agenți AI pentru afacerea ta"
- **Tagline EN**: "AI Agents for your business"

### Paletă de Culori (NOUĂ)
```css
/* Primary - Cyan vibrant */
--primary-400: #22d3ee;  /* Main cyan din logo */
--primary-500: #06b6d4;
--primary-600: #0891b2;  /* Hover */

/* Accent - Purple electric */
--accent-500: #a855f7;
--accent-600: #8b5cf6;   /* Main purple din logo */

/* Neutral - Warm dark */
--neutral-50: #fafafa;   /* Light background */
--neutral-900: #18181b;  /* Dark background */

/* Gradient Brand */
background: linear-gradient(135deg, #22d3ee 0%, #8b5cf6 100%);
```

### Logo
- **Component**: `frontend/src/components/common/Logo.astro`
- **Design**: Litera "G" cu gradient + noduri orbitale animate
- **Variante**: `default` (pe light), `white` (pe dark)
- **Referință PNG**: `docs/branding/logo-concepts/generativa-logo-final-dark.png`

### Fișiere actualizate pentru branding:
- `frontend/tailwind.config.mjs` - culori noi
- `frontend/src/styles/global.css` - stiluri brand
- `frontend/src/components/common/Logo.astro` - logo SVG nou
- `frontend/src/components/common/Header.astro` - folosește Logo
- `frontend/src/components/common/Footer.astro` - folosește Logo
- `frontend/src/components/common/Button.astro` - variant `gradient`
- `frontend/src/i18n/locales/ro.json` - texte actualizate
- `frontend/src/i18n/locales/en.json` - texte actualizate
- `frontend/src/layouts/BaseLayout.astro` - meta tags + noindex staging
- `frontend/public/favicon.svg` - favicon nou

---

## 🌐 DEPLOYMENT

### URLs
| Component | URL | Status |
|-----------|-----|--------|
| **Frontend Prod** | https://diginest-ai-platform.vercel.app | ✅ LIVE (vechi) |
| **Frontend Staging** | *preview URL la push* | Pending |
| **Backend API** | https://diginest-backend-production.up.railway.app | ✅ LIVE |
| **GitHub Repo** | https://github.com/IleanaOneata/diginest-ai-platform | ✅ |

### Vercel
- **Project**: diginest-ai-platform
- **Root Directory**: frontend
- **Framework**: Astro
- **Auto-deploy**: main → prod, alte branches → preview URLs

### Railway (Backend)
- **Project ID**: 6d320adf-7124-42ea-8741-6b6faae2fab4
- **Service**: diginest-backend
- **Runtime**: Java 21

### SEO - Protecție staging
```javascript
// În BaseLayout.astro - automat noindex pe staging
const isStaging = import.meta.env.PUBLIC_STAGING === 'true' ||
                  Astro.url.hostname.includes('vercel.app');
const shouldNoIndex = noIndex || isStaging;
```

---

## 💻 TECH STACK

### Frontend
- **Astro 4.15** + **Tailwind CSS 3.x** + **TypeScript**
- **i18n**: Română (default) + Engleză cu prefix URL (/ro/, /en/)
- **Deploy**: Vercel

### Backend
- **Java 21** + **Spring Boot 3.2.4**
- **PostgreSQL 16** (Supabase) / H2 (dev)
- **Deploy**: Railway

---

## 📂 STRUCTURA RELEVANTĂ

```
frontend/
├── src/
│   ├── components/
│   │   └── common/
│   │       ├── Logo.astro        # 🆕 Logo GENERATIVA
│   │       ├── Header.astro      # 🔄 Actualizat
│   │       ├── Footer.astro      # 🔄 Actualizat
│   │       └── Button.astro      # 🔄 Variant gradient
│   ├── layouts/
│   │   └── BaseLayout.astro      # 🔄 noindex staging
│   ├── i18n/locales/
│   │   ├── ro.json               # 🔄 GENERATIVA
│   │   └── en.json               # 🔄 GENERATIVA
│   └── styles/
│       └── global.css            # 🔄 Culori noi
├── public/
│   ├── favicon.svg               # 🔄 Favicon nou
│   └── images/
│       └── generativa-logo.png   # Logo PNG
├── tailwind.config.mjs           # 🔄 Culori brand
└── package.json

docs/branding/
├── BRANDING-NOTES.md             # Documentație branding
└── logo-concepts/
    └── generativa-logo-final-dark.png
```

---

## 🔧 COMENZI UTILE

### Frontend Development
```bash
cd frontend
cmd                    # În VS Code (evită PowerShell)
npm run dev           # http://localhost:3000/ro/
npm run build         # Build producție
```

### Git Workflow (Staging)
```bash
# Pe branch staging
git add .
git commit -m "Descriere"
git push -u origin staging    # Prima dată
git push                      # Ulterior

# Când e gata pentru producție
git checkout main
git merge staging
git push
```

---

## 📋 TODO-URI PRIORITARE

### 🔴 Imediat
- [ ] Commit modificări pe staging
- [ ] Push și verificare preview URL
- [ ] Finisare design logo (dacă e nevoie)

### 🟡 Curând
- [ ] Achiziționare domeniu generativa.ro
- [ ] Configure email service în Railway
- [ ] Test contact form end-to-end

### 🟢 După lansare
- [ ] Merge staging → main
- [ ] Configurare domeniu în Vercel
- [ ] Submit sitemap la Google

---

## 👤 CONSTRÂNGERI UTILIZATOR

- **Sistem**: Windows (Lenovo laptop)
- **Drepturi admin**: NU
- **IDE**: VS Code (frontend), IntelliJ IDEA (backend)
- **Terminal**: Folosește `cmd` în VS Code (nu PowerShell - erori execuție)
- **Git identity**: IleanaOneata (cont personal)

---

## 📝 NOTE IMPORTANTE

1. **PowerShell nu funcționează** pentru npm în VS Code → folosește `cmd`
2. **Branch main = producție** → nu face push direct pe main
3. **Vercel auto-deploy** → orice push pe main merge în producție
4. **noindex automat** → toate preview URLs sunt protejate de indexare

---

*Ultima actualizare: Februarie 2026 - Sesiune rebranding GENERATIVA*

# Ghid de Mentenanță și Evoluție - GENERATIVA AI Platform

## 📋 Cuprins

1. [Mentenanță Curentă](#mentenanță-curentă)
2. [Actualizarea Conținutului](#actualizarea-conținutului)
3. [Securitate](#securitate)
4. [Performanță](#performanță)
5. [Monitorizare](#monitorizare)
6. [Backup & Recovery](#backup--recovery)
7. [Roadmap Tehnic](#roadmap-tehnic)

---

## 🔧 Mentenanță Curentă

### Actualizări Săptămânale

```bash
# Frontend - verifică și actualizează dependențele
cd frontend
npm outdated
npm update

# Backend - verifică dependențele
cd backend
./mvnw versions:display-dependency-updates
```

### Actualizări Lunare

1. **Security patches** - Rulează `npm audit` și `mvn dependency-check:check`
2. **Dependency updates** - Actualizează versiuni minore
3. **Content review** - Verifică textele și link-urile

### Actualizări Trimestriale

1. **Major version updates** - Astro, Spring Boot
2. **Performance audit** - Lighthouse, Core Web Vitals
3. **SEO/AEO audit complet** - Vezi secțiunea dedicată mai jos
4. **UX review** - Analizează comportamentul utilizatorilor

---

## 📝 Actualizarea Conținutului

### Modificarea Textelor

Textele sunt în fișierele de traduceri:

```
frontend/src/i18n/locales/ro.json  # Română
frontend/src/i18n/locales/en.json  # Engleză
```

**Exemplu de modificare:**

```json
// Schimbă tagline-ul
{
  "site": {
    "tagline": "Noul tagline aici"
  }
}
```

### Blog & Studii de Caz

> **Status (Februarie 2026)**: Blog-ul și secțiunea de studii de caz au fost **eliminate** din navigare (Header + Footer). Paginile goale dăunează SEO la un business nou (crawl budget waste, bounce rate, thin content). Se vor reimplementa când există conținut real de publicat.

---

## 🔒 Securitate

### Checklist Lunar

- [ ] Verifică `npm audit` pentru vulnerabilități
- [ ] Verifică `mvn dependency-check:check` pentru backend
- [ ] Review logs pentru activitate suspectă
- [ ] Verifică certificatul SSL (expirare)
- [ ] Testează rate limiting

### Practici Obligatorii

1. **Nu stoca secrete în cod** - Folosește environment variables
2. **Actualizează dependențele** - Mai ales security patches
3. **Review CORS settings** - Doar domeniile necesare
4. **Monitorizează rate limits** - Ajustează dacă e nevoie

### În Caz de Incident

1. Verifică logs în Railway/Render dashboard
2. Analizează traffic-ul în analytics
3. Blochează IP-uri suspecte (dacă e cazul)
4. Documentează incidentul

---

## ⚡ Performanță

### Targets Core Web Vitals

| Metric | Target | Tool |
|--------|--------|------|
| LCP | < 2.5s | Lighthouse |
| FID | < 100ms | Lighthouse |
| CLS | < 0.1 | Lighthouse |
| TTFB | < 600ms | WebPageTest |

### Optimizări Frontend

```bash
# Analizează bundle size
cd frontend
npm run build -- --analyze

# Verifică imagini neoptimizate
# Folosește WebP format, lazy loading
```

### Optimizări Backend

```java
// Monitorizează query-urile lente
// În application-prod.yml:
logging:
  level:
    org.hibernate.stat: DEBUG
```

---

## 📊 Monitorizare

### Metrici de Urmărit

**Business:**
- Număr de lead-uri / lună
- Conversion rate (vizitatori → lead)
- Bounce rate
- Time on site

**Tehnice:**
- Uptime (target: 99.9%)
- Response time API (target: < 200ms)
- Error rate (target: < 0.1%)

### Tools Recomandate

1. **Plausible/Umami** - Analytics (privacy-friendly)
2. **Railway/Render Metrics** - Backend monitoring
3. **Vercel Analytics** - Frontend performance
4. **Better Uptime** - Uptime monitoring (free tier)

### Alerte

Configurează alerte pentru:
- Uptime sub 99%
- Error rate peste 1%
- Response time peste 500ms
- Lead-uri = 0 într-o zi lucrătoare

---

## 💾 Backup & Recovery

### Backup Automat

**Database (PostgreSQL via Supabase/Railway):**
- Backup automat zilnic
- Retenție: 7 zile (free tier)

**Cod:**
- Git repository pe GitHub
- Multiple branches pentru safety

### Recovery Procedure

1. **Frontend down:**
   - Vercel re-deploy automat din main
   - Manual: `vercel --prod` din local

2. **Backend down:**
   - Railway auto-restart
   - Manual: redeploy din dashboard

3. **Database corruption:**
   - Restore din backup
   - Contact Supabase/Railway support

---

## 🔍 SEO & AEO Audit (Proceduri Trimestriale)

> **Document de referință complet**: `docs/SEO-AEO-GUIDELINES.md`

### Audit Trimestrial — Checklist Complet

Rulează acest checklist la fiecare 3 luni sau la adăugarea unei pagini noi.

#### 1. Schema.org Validation

```
Pentru FIECARE pagină de pe site:
```

- [ ] View source → verifică 2× `<script type="application/ld+json">`
- [ ] Organization schema prezent (adăugat de BaseLayout)
- [ ] Page-specific @graph prezent cu tipurile corecte
- [ ] Testează cu [Rich Results Test](https://search.google.com/test/rich-results)
- [ ] Testează cu [Schema Validator](https://validator.schema.org/)
- [ ] Verifică `@id` unic per pagină/tip

**Schema.org așteptate per pagină:**

| Pagină | Scheme Obligatorii |
|--------|-------------------|
| Homepage | WebSite + WebPage + BreadcrumbList |
| About | AboutPage (cu Organization) + BreadcrumbList |
| Contact | ContactPage + ContactPoint + BreadcrumbList |
| Service pages | Service + FAQPage + BreadcrumbList + HowTo |

#### 2. Meta Tags Audit

- [ ] Fiecare pagină: `<title>` unic, 50-70 caractere
- [ ] Fiecare pagină: `<meta name="description">` unic, 140-160 caractere
- [ ] Fiecare pagină: `<link rel="canonical">` cu trailing slash
- [ ] Keywords la începutul title-ului
- [ ] CTA implicit în meta description
- [ ] `noindex` prezent pe staging, ABSENT pe producție

#### 3. Heading Structure Audit

- [ ] Exact 1× `<h1>` per pagină
- [ ] H2-uri question-based pe paginile de serviciu
- [ ] Ierarhie corectă: H1 → H2 → H3 (niciodată skip)
- [ ] Lead paragraph (40-60 cuvinte) imediat după fiecare H2 pe service pages

#### 4. FAQ Audit

- [ ] Minim 6 FAQ items pe fiecare pagină de serviciu
- [ ] Întrebările targetează People Also Ask reale
- [ ] Selectori FAQ unici per pagină (verifică JS console pentru coliziuni)
- [ ] FAQPage schema se sincronizează cu conținutul vizual
- [ ] Răspunsurile sunt concise (2-4 propoziții) și factuale

#### 5. Breadcrumb Audit

- [ ] BreadcrumbList schema pe fiecare pagină
- [ ] Breadcrumb vizual renderizat corect
- [ ] Ultimul element fără `item` URL (pagina curentă)
- [ ] Nivelurile intermediare au `item` cu URL corect

#### 6. Language Switcher Audit

- [ ] Path mappings în `i18n/index.ts` pentru TOATE paginile
- [ ] RO → EN și EN → RO funcționează pe fiecare pagină
- [ ] URL-urile generate sunt corecte (nu 404)

#### 7. Performance & Core Web Vitals

- [ ] [PageSpeed Insights](https://pagespeed.web.dev/) score ≥ 90 pe fiecare pagină
- [ ] LCP < 2.5s, FID < 100ms, CLS < 0.1
- [ ] Mobile performance OK

#### 8. Content Freshness

- [ ] FAQ items sunt relevante și actuale
- [ ] Numerele/statisticile din content sunt actuale
- [ ] Link-uri externe funcționează
- [ ] People Also Ask — verifică dacă au apărut întrebări noi de targetat

### Audit Lunar — Quick Check

- [ ] `npm run build` — zero erori
- [ ] Rich Results Test pe URL-urile principale (homepage, service pages)
- [ ] Google Search Console — verifică erori indexare (dacă configurat)
- [ ] Verifică 404-uri noi (pagini șterse/mutate)

### Tools Necesare

| Tool | URL | Scop | Cost |
|------|-----|------|------|
| Rich Results Test | https://search.google.com/test/rich-results | Validare schema pentru rich results | Gratuit |
| Schema Validator | https://validator.schema.org/ | Validare sintaxă JSON-LD | Gratuit |
| PageSpeed Insights | https://pagespeed.web.dev/ | Core Web Vitals + SEO score | Gratuit |
| Google Search Console | https://search.google.com/search-console | Indexare, erori, ranking | Gratuit |
| Ahrefs Webmaster | https://ahrefs.com/webmaster-tools | SEO audit complet, backlinks | Gratuit (basic) |
| Screaming Frog | https://www.screamingfrog.co.uk/seo-spider/ | Crawl complet site | Gratuit (<500 URLs) |

### Când Se Adaugă O Pagină Nouă

Urmează checklist-ul complet din `docs/SEO-AEO-GUIDELINES.md` secțiunea 8 (Page Shell Template) și secțiunea 13 (Checklist Rapid).

**Sumar acțiuni la pagină nouă:**
1. Traduceri `ro.json` + `en.json`
2. Path mappings `i18n/index.ts` — **CRITIC** pentru hreflang + Language Switcher
3. Component `.astro` cu H2 question-based + lead paragraphs
4. Page shells RO + EN cu Schema.org @graph
5. FAQ accordion cu selector unic
6. Update `CLAUDE.md` (implementat list, 404 table, session history)
7. Build + push + verificare Rich Results Test
8. Verificare hreflang generat corect (build → check HTML)

---

## 🗺️ Roadmap Tehnic

### Faza 2: Backend Enhancement (Lună 2-3)

- [x] Integrare completă contact form cu API (Resend HTTP API, async emails)
- [x] Contact form cu validare custom locale-aware + lead qualification (Industry/Interest dropdowns)
- [ ] Câmpuri `industry` + `interest` dedicate în backend DTO/entity/DB (acum se prepend la mesaj)
- [ ] Newsletter subscription
- [ ] Admin dashboard simplu pentru leads
- [ ] Email templates HTML

### Faza 3: AI Demo (Lună 3-4)

- [ ] Chat widget cu OpenAI/Claude
- [ ] Demo scenarii predefinite
- [ ] Rate limiting per utilizator
- [ ] Analytics pentru demo usage

### Faza 4: Scale (Lună 5+)

- [ ] Blog CMS (poate Decap CMS) — reimplementare când există conținut real
- [ ] Multi-language content auto-generate
- [ ] A/B testing pentru CTA
- [ ] Advanced analytics

### Considerații pentru Scalare

1. **CDN caching** - Deja prin Vercel/Cloudflare
2. **Database scaling** - Upgrade Supabase plan când e necesar
3. **API rate limiting** - Ajustare pe baza traficului
4. **Image optimization** - Consider Cloudinary pentru multe imagini

---

## 📞 Suport și Resurse

### Documentație

- [Astro Docs](https://docs.astro.build)
- [Spring Boot Docs](https://docs.spring.io/spring-boot)
- [Tailwind CSS](https://tailwindcss.com/docs)

### Comunitate

- Astro Discord
- Spring Community Forums
- Stack Overflow

### Contacte Interne

- **Technical Lead**: [email]
- **DevOps**: [email]
- **Design**: [email]

---

### Visual Identity Guidelines (Februarie 2026)

Când modifici componente vizuale, respectă aceste reguli:

| Element | Specificație |
|---------|-------------|
| **Font UI** | Inter (Google Font) — weights 400, 500, 600, 700 |
| **Font Logo** | Prompt (Google Font) — weights 600, 700 (doar în Logo.astro SVG) |
| **Primary color** | Deep Slate `#1E293B` (primary-800) — autoritate, încredere |
| **Accent color** | Warm Amber `#F59E0B` (accent-500) — CTA, conversie |
| **CTA buttons** | Flat `background: #F59E0B`, hover `#D97706` — NU gradient |
| **Dark gradient** | `radial-gradient(ellipse at top, #1E293B 0%, #0F172A 50%, #020617 100%)` |
| **Heading color** | `#263244` (neutral-750) pe light backgrounds, `text-white` pe dark |
| **Card radius** | 16px |
| **Button/Input radius** | 12px |
| **Badge radius** | 999px |
| **Shadow** | `shadow-soft` (custom) — nu shadow-lg standard |

**⚠️ Important**: `text-neutral-750` NU funcționează cu `@apply` în CSS. Folosește `color: #263244` direct.

**Regula 60-30-10**: 60% neutral (alb/gri deschis), 30% deep slate (structură), 10% amber (doar CTA și accente interactive).

**Referință completă**: `docs/branding/BRANDING-NOTES.md`

---

*Ultima actualizare: 11 Februarie 2026 — Option D (Deep Slate + Warm Amber), Inter UI font, Prompt logo only*

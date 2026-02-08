# GENERATIVA - AI Agents Platform

> **Pentru AI în sesiuni noi**: Citește ÎNTREGUL acest fișier înainte de a începe orice task. Conține context critic despre business, produs, strategie și decizii tehnice.

---

## 🚨 STATUS CURENT (Februarie 2026)

### Branch-uri Git
| Branch | Scop | URL |
|--------|------|-----|
| `main` | Producție (versiunea veche Diginest) | https://diginest-ai-platform.vercel.app |
| `staging` | **ACTIV** - Rebranding GENERATIVA | Preview URL generat la fiecare push |

### Ce s-a implementat:
1. ✅ Rebranding complet Diginest → GENERATIVA
2. ✅ Logo SVG nou cu gradient cyan→purple și noduri orbitale animate
3. ✅ Paletă de culori nouă în tot site-ul
4. ✅ Branch `staging` pentru dezvoltare (protejat de indexare Google)
5. ✅ Analiză competitivă detaliată (Agentic.ro, Inflate.agency, Stripe)
6. ✅ Strategie de diferențiere "Demo-First + Storytelling"
7. ✅ **HeroInteractive** - Chat Simulator cu conversație animată
8. ✅ **BenefitsStrip** - 6 beneficii vizuale sub Hero
9. ✅ **UseCases** - Secțiune auto-identificare "Ți se pare familiar?"
10. ✅ **IntegrationHub** - Vizualizare conexiuni stil Stripe (redesign complet)
11. ✅ **ScaleWithConfidence** - Animație wave Canvas pentru scalare (vezi secțiunea dedicată)
12. ✅ **ScrollToTop** - Buton floating pentru navigare rapidă sus
13. ✅ **CookieBanner** - Redesign modern corner popup (GDPR compliant)
14. ✅ **Hero Stats Redesign** - Carduri glassmorphism cu counter animation
15. ✅ **Mobile Optimization** - Scroll orizontal pentru carduri (vezi secțiunea dedicată)
16. ✅ **Backend Email Funcțional** - Resend HTTP API, PostgreSQL, async emails (vezi secțiunea dedicată)
17. ✅ **Contact Form UX** - Mesaj succes auto-hide după 5s, processed tracking în DB
18. ✅ **Automatizare Procese Page** - Prima pagină de serviciu cu SEO/AEO, Schema.org @graph (Service + FAQPage + BreadcrumbList + HowTo), FAQ accordion, question-based H2s
19. ✅ **Site-wide SEO/AEO Audit** - Schema.org pe toate paginile (Homepage, About, Contact), fix domain URLs, BreadcrumbList universal
20. ✅ **Agenți Conversaționali Page** - A doua pagină de serviciu cu 7 secțiuni, SEO/AEO, Schema.org @graph, 8 FAQ items, 6 industrii cu problem→solution
21. ✅ **Integrări AI Page** - A treia pagină de serviciu cu 7 secțiuni (Systems, Approach, Capabilities, Benefits, FAQ, CTA), SEO/AEO, Schema.org @graph, 8 FAQ items, hasOfferCatalog (CRM/Booking/Ticketing/ERP)
22. ✅ **Fix 404 Servicii** - Link-ul "Servicii" din header/breadcrumb duce la homepage `/#services` (scroll), nu la pagină separată
23. ✅ **Blog & Resources Cleanup** - Eliminat Blog din Header și secțiunea Resurse din Footer (pagini goale dăunează SEO la business nou)
24. ✅ **Custom Form Validation** - Validare inline locale-aware (`novalidate` + JS custom), mesaje de eroare în limba paginii, regex email + E.164 phone (7-15 cifre)
25. ✅ **Contact Form Lead Qualification** - Dropdown-uri Industry (8 opțiuni) și Interest (4 opțiuni) pentru calificarea lead-urilor înainte de primul contact
26. ✅ **Unificare ScaleWithConfidence + Benefits** - Eliminat secțiunea Benefits separată, cardurile (70%, 24/7, 10x, 300%) integrate sub animația wave într-o singură secțiune dark coerentă
27. ✅ **Politica de Confidențialitate** - Pagină legală GDPR-compliant cu 12 secțiuni + Politica de Cookies (5 secțiuni), Schema.org WebPage + BreadcrumbList, RO + EN
28. ✅ **Termeni și Condiții** - Pagină legală cu 10 secțiuni (servicii, proprietate intelectuală, limitarea răspunderii, legislație), Schema.org WebPage + BreadcrumbList, RO + EN
29. ✅ **Footer Update** - Înlocuit placeholder company info cu datele reale DIGITAL LEADERSHIP SRL (CUI: 38585123, J12/6715/2017)
30. ✅ **Hreflang Fix** - Corectare hreflang tags în BaseLayout: `buildAlternatePath()` pentru traducere corectă path-uri, `x-default` → RO (piață principală), Organization schema cu adresă reală
31. ✅ **Language Switcher Redesign** - Toggle pill compact (RO | EN) cu gradient brand, fără emoji flags (best practice 2025: flags = țări, nu limbi), accessibility complet (aria-current, lang attributes)
32. ✅ **Services Mobile Scroll** - Carduri servicii scroll orizontal pe mobile (flex md:grid pattern)
33. ✅ **Logo Redesign PNG** - Înlocuit SVG logo cu 3D G letter PNG (transparent background), imagine AI-generated, Logo.astro rescris complet
34. ✅ **Header Gradient** - Fundal header cu gradient subtil cyan→white→lavender (`from-primary-50/80 via-white/80 to-accent-50/60`) + ambient color blobs în BaseLayout
35. ✅ **IntegrationHub Mobile Labels** - Afișare label-uri sub iconițe pe toate dimensiunile (nu doar pe sm:+)
36. ✅ **Favicon PNG Update** - Favicon-ul din tab-ul Chrome actualizat de la SVG vechi la PNG-uri generate din noul logo 3D (32x32, 16x16, apple-touch-icon 180x180)
37. ✅ **CTA Redesign (Stripe-inspired)** - Dark gradient, eyebrow badge, gradient button cu glow, trust indicators. Canvas ribbon animation testată și respinsă. Buton secundar "Cum funcționează?" eliminat (link stricat + un singur CTA clar e mai eficient)
38. ✅ **Section Spacing Optimization** - Reducere spațiere între secțiuni (Services pt-10/md:pt-14, UseCases pt-10/md:pt-14), normalizare IntegrationHub mobile (py-12→py-16), reducere CTA (py-20/28/36→py-16/24/28)
39. ✅ **Mobile Card Centering** - Carduri centrate pe mobile (`w-[85vw]` + `snap-center`) pe toate paginile: 3 service pages, About, Homepage (Services, UseCases, BenefitsStrip, IntegrationHub)
40. ✅ **Dynamic Scroll Arrows** - Săgeți de direcție dinamice pe mobile: arată doar direcția disponibilă (dreapta la start, ambele la mijloc, stânga la final). Pattern `data-scroll-hint` + `data-scroll-container` cu JS pe scroll event
41. ✅ **AI Integrations 6th Capability** - Adăugat "Notificări și alerte inteligente" (Smart notifications & alerts) pe pagina Integrări AI pentru grid complet 3+3 pe desktop
42. ✅ **Language Switcher Scroll Preservation** - La schimbarea limbii (RO↔EN), utilizatorul rămâne în aceeași poziție pe pagină. Scroll position salvat ca procent în `sessionStorage`, restaurat instant (`behavior: 'instant'`) pe pagina nouă

### În lucru:
- [ ] Rafinare conținut și copy pentru toate secțiunile
- [ ] Test complet pe staging
- [ ] Verificare vizuală pe cel mai recent preview URL Vercel

### Următorii pași:
1. [ ] Verificare staging URL după deploy
2. [ ] Achiziție domeniu generativa.ro
3. [ ] Merge în `main` când e aprobat

---

## 🎯 CONTEXT BUSINESS & PRODUS

### Ce este GENERATIVA?

**GENERATIVA** este o agenție care oferă **agenți AI inteligenți** pentru automatizarea comunicării cu clienții. Produsul principal: **asistenți vocali și chat** care răspund la telefon, WhatsApp, email - 24/7, fără pauze.

### Propunere de Valoare (Value Proposition)

> "Nu vindem tehnologie AI. Oferim liniște sufletească - știi că fiecare client primește răspuns, fiecare oportunitate e capturată, fără să angajezi mai mulți oameni."

### Problema pe care o rezolvăm

| Problemă | Impact | Soluția noastră |
|----------|--------|-----------------|
| Apeluri pierdute în afara programului | Clienți pierduți la competiție | Răspuns 24/7 automat |
| Recepție copleșită de apeluri repetitive | Angajați frustrați, erori | AI preia întrebările simple |
| Experiență inconsistentă între locații | Brand damage | Un singur standard pentru toate |
| No-show la programări | Revenue pierdut | Confirmări și reminder-e automate |
| Copy-paste manual între sisteme | Timp pierdut, erori | Integrare automată CRM/Calendar |

### Obiective de Business la Lansare
- Generarea de **20+ lead-uri calificate/lună**
- Conversion rate lead→call: **30%**
- Poziționarea ca **lider AI în România** pentru SME-uri
- Construirea încrederii prin **demo-uri live**, nu promisiuni

### Public Țintă

**Tip**: B2B - SME-uri din România și UE

**Industrii prioritare** (în ordinea importanței):
1. Clinici dentare
2. Cabinete medicale
3. Saloane de beauty/SPA
4. Service-uri auto
5. Restaurante cu rezervări
6. Rețele cu multiple locații

**Decidenți**:
- CEO / Owner (pentru SME-uri mici)
- CTO / Head of Operations (pentru companii medii)
- Office Manager / Reception Lead

**Profil psihografic**:
- Nivel de înțelegere AI: **mediu** (știu că există, nu știu cum funcționează)
- Durere principală: **timp pierdut** și **oportunități ratate**
- Frică: "AI o să înlocuiască angajații" / "E prea complicat"
- Motivație: **eficiență**, nu tehnologie cool

---

## 📊 STRATEGIE DE DIFERENȚIERE

### Competiția Analizată

| Competitor | URL | Ce fac | Puncte slabe |
|------------|-----|--------|--------------|
| **Agentic.ro** | https://agentic.ro/ | AI Agents RO, dark theme agresiv, promisiuni bold (-90% costuri) | Overwhelming, generic, fără demo |
| **Inflate.agency** | https://www.inflate.agency/ | Voice AI, design minimalist, demo video în Hero | Focus doar voice, mai puțin localizat |
| **Stripe** | https://stripe.com/ | (Inspirație design) Alternanță culori elegantă, glassmorphism | N/A - nu e competitor direct |

### Cum ne diferențiem

| Aspect | Competiția | GENERATIVA |
|--------|------------|------------|
| **Hero** | Grafică abstractă / video | **Chat Simulator interactiv** - valoare în 5 secunde |
| **Design** | Dark neon agresiv | **Light theme warm** + secțiuni dark elegante (stil Stripe) |
| **Promisiuni** | "-90% costuri!", "0% erori!" | **Realistic**: "15-20 ore economie/săptămână" |
| **Ton** | Corporate/robotic | **Uman, empatic**: "Hai să vedem împreună" |
| **Flow** | Features → Pricing | **Problemă → Soluție vizuală → Rezultate → CTA natural** |
| **Trust** | Logo-uri clienți | **Demo live** + scenarii concrete din industrii |

### Abordarea "Demo-First + Storytelling"

**Principiu**: Vizitatorii văd AI-ul în acțiune în primele 5 secunde și înțeleg transformarea, nu doar features.

**Flow-ul paginii (implementat)**:
```
1. HeroInteractive     → Chat Simulator animat (WOW factor)
2. BenefitsStrip       → 6 beneficii vizuale (impact instant)
3. Services            → Ce oferim (existent)
4. UseCases            → "Ți se pare familiar?" (auto-identificare)
5. IntegrationHub      → Vizualizare conexiuni (stil Stripe)
6. ScaleWithConfidence → Animație wave + metrici business (unificate)
7. Process             → Cum funcționează (existent)
8. FAQ                 → Întrebări frecvente (existent)
9. CTA                 → Contact (existent)
```

---

## 🎨 BRANDING & DESIGN SYSTEM

### Identitate Vizuală
- **Nume**: GENERATIVA
- **Domeniu țintă**: generativa.ro (de achiziționat)
- **Tagline RO**: "Agenți AI pentru afacerea ta"
- **Tagline EN**: "AI Agents for your business"

### Paletă de Culori

```css
/* Primary - Cyan vibrant (tehnologie, inovație) */
--primary-400: #22d3ee;  /* Main cyan din logo */
--primary-500: #06b6d4;
--primary-600: #0891b2;  /* Hover states */

/* Accent - Purple electric (creativitate, AI) */
--accent-500: #a855f7;
--accent-600: #8b5cf6;   /* Main purple din logo */

/* Neutral - Warm tones */
--neutral-50: #fafafa;   /* Light backgrounds */
--neutral-900: #18181b;  /* Dark text */

/* Dark sections (stil Stripe) */
--dark-bg: linear-gradient(to-br, #0a1628, #0f172a, #1e1b4b);

/* Brand Gradient */
background: linear-gradient(135deg, #22d3ee 0%, #8b5cf6 100%);
```

### Principii de Design (învățate de la Stripe)

1. **Restraint elegant** - puterea din spațiu, nu din decorații
2. **Gradient > Solid** - adaugă subtilitate, nu flat colors
3. **Transparency > Opacity** - glassmorphism pentru modernitate
4. **Animate subtil** - linii dashed, hover glow, NU bounce agresiv
5. **Dark ≠ Black** - folosește dark blue/purple (`#0a1628`), nu `#000000`
6. **Alternanță Light/Dark** - ritmul vizual menține atenția

### Logo
- **Component**: `frontend/src/components/common/Logo.astro`
- **Design**: 3D G letter PNG cu transparent background (AI-generated, glossy cyan-blue 3D effect)
- **Fișier imagine**: `/images/generativa-g-512.png` (512x512, transparent PNG)
- **Favicon**: `/favicon-32.png`, `/favicon-16.png`, `/apple-touch-icon.png` (generate din logo-ul PNG cu Sharp)
- **Variante**: `default` (pe light, text gradient), `white` (pe dark, text alb), `dark` (text dark)
- **Sizes**: `sm` (w-9), `md` (w-11), `lg` (w-14), `xl` (w-20)
- **IMPORTANT**: Nu mai folosim SVG logo. `favicon.svg` vechi există încă în repo dar NU e referit nicăieri.

---

## 🏗️ ARHITECTURA PAGINII PRINCIPALE

### Componente Noi Create

| Component | Fișier | Scop |
|-----------|--------|------|
| **ChatSimulator** | `components/demo/ChatSimulator.astro` | Chat animat cu typing effect, auto-play |
| **HeroInteractive** | `components/sections/HeroInteractive.astro` | Hero cu demo în dreapta |
| **BenefitsStrip** | `components/sections/BenefitsStrip.astro` | 6 beneficii în strip vizual |
| **UseCases** | `components/sections/UseCases.astro` | Auto-identificare pe industrii |
| **IntegrationHub** | `components/sections/IntegrationHub.astro` | Vizualizare conexiuni (stil Stripe) |
| **ScaleWithConfidence** | `components/sections/ScaleWithConfidence.astro` | Animație wave Canvas (scalare, throughput) |
| **ScrollToTop** | `components/common/ScrollToTop.astro` | Buton floating pentru scroll to top |
| **CookieBanner** | `components/common/CookieBanner.astro` | Cookie consent modern corner popup |

### Flow Homepage (RO & EN)

```
frontend/src/pages/ro/index.astro
frontend/src/pages/en/index.astro

Secțiuni în ordine:
1. <HeroInteractive />      - Demo chat + headline + CTA
2. <BenefitsStrip />        - 6 beneficii vizuale
3. <Services />             - Ce oferim (3 servicii)
4. <UseCases />             - 6 industrii cu problemă→soluție
5. <IntegrationHub />       - Hub central + 8 conexiuni
6. <ScaleWithConfidence />  - Animație wave + metrici business (unificate)
7. <Process />              - 4 pași cum funcționăm
8. <FAQ />                  - Întrebări frecvente
9. <CTA />                  - Contact final
```

### Conținut Cheie per Secțiune

**HeroInteractive**:
- Headline: "Agenți AI care răspund clienților tăi 24/7"
- Demo: Conversație client→AI pentru tracking comandă
- Stats: 0.8s răspuns, 24/7 disponibil, 90% rezolvate automat

**BenefitsStrip** (6 beneficii):
1. Disponibil 24/7
2. Zero apeluri pierdute
3. Răspuns instant
4. Echipă relaxată
5. Experiență consistentă
6. Mai multe conversii

**UseCases** (6 industrii):
1. Clinică dentară - programări automate
2. Cabinet medical - răspuns în afara programului
3. Rețea locații - experiență unificată
4. Service auto - status mașină automat
5. Salon beauty - reducere no-show 60%
6. Restaurant - rezervări fără pierderi

**IntegrationHub** (8 conexiuni):
- Apeluri telefonice, WhatsApp, Email, SMS
- CRM, Calendar, Notificări echipă, Software existent
- Centru: GENERATIVA - Coordonare centrală

---

## 💻 TECH STACK

### Frontend
- **Framework**: Astro 4.15
- **Styling**: Tailwind CSS 3.x
- **Language**: TypeScript
- **i18n**: Română (default) + Engleză cu prefix URL (/ro/, /en/)
- **Deploy**: Vercel (auto-deploy din GitHub)

### Backend
- **Runtime**: Java 21
- **Framework**: Spring Boot 3.2.4
- **Database**: PostgreSQL 16 (Supabase prod) / H2 (dev)
- **Deploy**: Railway

### URLs Live
| Component | URL | Status |
|-----------|-----|--------|
| Frontend Prod | https://diginest-ai-platform.vercel.app | ✅ LIVE (vechi) |
| Frontend Staging | *preview URL la push* | ✅ Auto-deploy |
| Backend API | https://diginest-backend-production.up.railway.app | ✅ LIVE |
| GitHub Repo | https://github.com/IleanaOneata/diginest-ai-platform | ✅ |

---

## 📂 STRUCTURA PROIECTULUI

```
AI Agents Platform/
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── common/
│   │   │   │   ├── Logo.astro           # Logo GENERATIVA animat
│   │   │   │   ├── Header.astro         # Navbar
│   │   │   │   ├── Footer.astro         # Footer
│   │   │   │   └── Button.astro         # Butoane (variant: gradient)
│   │   │   ├── demo/
│   │   │   │   └── ChatSimulator.astro  # 🆕 Chat animat pentru Hero
│   │   │   └── sections/
│   │   │       ├── HeroInteractive.astro # 🆕 Hero cu demo
│   │   │       ├── BenefitsStrip.astro   # 🆕 6 beneficii vizuale
│   │   │       ├── UseCases.astro        # 🆕 Auto-identificare industrii
│   │   │       ├── IntegrationHub.astro  # 🆕 Hub conexiuni (stil Stripe)
│   │   │       ├── ProcessAutomationPage.astro # 🆕 Pagina serviciu automatizare (SEO/AEO)
│   │   │       ├── ConversationalAgentsPage.astro # 🆕 Pagina serviciu agenți conversaționali (SEO/AEO)
│   │   │       ├── AiIntegrationsPage.astro # 🆕 Pagina serviciu integrări AI (SEO/AEO)
│   │   │       ├── PrivacyPolicyPage.astro  # 🆕 Politica de confidențialitate + Cookie Policy
│   │   │       ├── TermsConditionsPage.astro # 🆕 Termeni și condiții
│   │   │       ├── Services.astro        # Servicii
│   │   │       ├── Benefits.astro        # Rezultate
│   │   │       ├── Process.astro         # Cum funcționăm
│   │   │       ├── FAQ.astro             # Întrebări frecvente
│   │   │       └── CTA.astro             # Contact
│   │   ├── layouts/
│   │   │   └── BaseLayout.astro          # Layout principal + noindex staging
│   │   ├── pages/
│   │   │   ├── ro/index.astro            # Homepage RO
│   │   │   ├── en/index.astro            # Homepage EN
│   │   │   └── ...
│   │   ├── i18n/locales/
│   │   │   ├── ro.json                   # Traduceri română
│   │   │   └── en.json                   # Traduceri engleză
│   │   └── styles/
│   │       └── global.css                # Stiluri globale
│   ├── public/
│   │   ├── favicon-32.png              # Favicon 32x32 (3D G logo PNG)
│   │   ├── favicon-16.png              # Favicon 16x16
│   │   ├── apple-touch-icon.png        # iOS icon 180x180
│   │   ├── favicon.svg                 # ⚠️ VECHI - nu mai e referit, păstrat în repo
│   │   └── images/
│   │       ├── generativa-g-512.png    # 🆕 Logo principal (3D G, transparent)
│   │       └── generativa-g-200.png    # 🆕 Logo mic
│   ├── tailwind.config.mjs               # Culori brand
│   └── package.json
│
├── backend/                              # Spring Boot API
│   └── ...
│
├── docs/
│   ├── STRATEGY.md                       # 📄 Strategie completă (CITEȘTE!)
│   ├── DEPLOYMENT.md                     # Ghid deployment
│   ├── MAINTENANCE.md                    # Ghid mentenanță
│   └── branding/
│       ├── BRANDING-NOTES.md
│       └── logo-concepts/
│
└── CLAUDE.md                             # 📄 ACEST FIȘIER
```

---

## 🔧 COMENZI UTILE

### Frontend Development
```bash
cd frontend
cmd                    # În VS Code (NU PowerShell!)
npm install            # Prima dată
npm run dev            # http://localhost:4321/ro/
npm run build          # Build producție
```

### Git Workflow
```bash
# Verifică branch-ul curent
git branch

# Lucrează pe staging
git checkout staging
git pull origin staging

# După modificări
git add .
git commit -m "Descriere clară"
git push origin staging

# Când e gata pentru producție
git checkout main
git merge staging
git push origin main
```

---

## 📋 TODO-URI PRIORITARE

### 🔴 Imediat
- [ ] Test complet pe localhost
- [ ] Push pe staging și verificare preview URL
- [ ] Ajustări responsive mobile

### 🟡 Curând
- [ ] Rafinare copy pentru toate secțiunile
- [ ] Achiziție domeniu generativa.ro
- [ ] Setup analytics (Plausible/Umami)

### 🟢 După lansare
- [ ] Merge staging → main
- [ ] Configurare domeniu custom în Vercel
- [ ] A/B testing pentru conversii
- [ ] Upgrade ChatSimulator cu AI real

---

## 👤 CONSTRÂNGERI UTILIZATOR

- **Sistem**: Windows (Lenovo laptop)
- **Drepturi admin**: NU
- **IDE**: VS Code (frontend), IntelliJ IDEA (backend)
- **Terminal**: Folosește `cmd` în VS Code (**NU PowerShell** - erori execuție)
- **Git identity**: IleanaOneata (cont personal GitHub)

---

## ⚠️ REGULI IMPORTANTE

1. **PowerShell nu funcționează** pentru npm în VS Code → folosește `cmd`
2. **Branch main = producție** → NU face push direct pe main
3. **Vercel auto-deploy** → orice push pe main merge INSTANT în producție
4. **noindex automat** → toate preview URLs sunt protejate de indexare Google
5. **Documentează în .md** → orice decizie importantă trebuie documentată pentru sesiuni viitoare
6. **SEO/AEO obligatoriu** → orice pagină nouă TREBUIE să respecte regulile din `docs/SEO-AEO-GUIDELINES.md`

---

## 🔍 SEO & AEO — REGULI OBLIGATORII

> **CITEȘTE `docs/SEO-AEO-GUIDELINES.md`** pentru documentul complet cu template-uri și exemple. Această secțiune conține regulile CRITICE pe scurt.

### De Ce Contează

Fiecare pagină este optimizată **dual**: SEO (Google clasic) + AEO (AI Overviews, Featured Snippets). Tehnicile se completează reciproc.

### Reguli Critice (Sumar)

| # | Regulă | Specificație |
|---|--------|--------------|
| 1 | **Title** | 50-70 chars, keyword la ÎNCEPUT, `GENERATIVA` la final |
| 2 | **Description** | 140-160 chars, include CTA ("Solicită demo", "Consultanță gratuită") |
| 3 | **H1** | Exact 1 per pagină, cuvântul cheie principal |
| 4 | **H2** | Question-based ("Ce face X?", "Cum funcționează X?") — OBLIGATORIU |
| 5 | **Lead paragraph** | 40-60 cuvinte imediat după H2, răspuns DIRECT la întrebare |
| 6 | **Schema.org** | Pattern `@graph` cu tipurile corecte per pagină (vezi mai jos) |
| 7 | **FAQ** | Minim 6 întrebări din People Also Ask, selector UNIC per pagină |
| 8 | **Canonical URL** | Cu trailing slash, pe FIECARE pagină |
| 9 | **Hreflang** | Automat în BaseLayout (`buildAlternatePath`), x-default → RO |
| 10 | **i18n paths** | Adaugă mapări în `i18n/index.ts` pentru Language Switcher + hreflang |

### Schema.org per Tip de Pagină

| Tip Pagină | Scheme în `@graph` |
|------------|-------------------|
| Homepage | WebSite + WebPage + BreadcrumbList |
| About | AboutPage (cu Organization) + BreadcrumbList |
| Contact | ContactPage + Organization (ContactPoint) + BreadcrumbList |
| Service | Service + FAQPage + BreadcrumbList + HowTo |
| Legal (Privacy, Terms) | WebPage + BreadcrumbList |

### FAQ Accordion — Naming Convention

| Pagina | Data Attribute | Function Name |
|--------|---------------|---------------|
| Homepage | `data-faq-trigger` | (inline) |
| Automatizare Procese | `data-service-faq-trigger` | `initServiceFaqAccordion` |
| Agenți Conversaționali | `data-conv-faq-trigger` | `initConvFaqAccordion` |
| Integrări AI | `data-integ-faq-trigger` | `initIntegFaqAccordion` |
| **Pagină Nouă** | `data-[prefix]-faq-trigger` | `init[Prefix]FaqAccordion` |

**Convenție**: Prefix scurt din slug pagină. NICIODATĂ reutiliza selector existent!

### Checklist Rapid — Pagină Nouă de Serviciu

- [ ] `ro.json` + `en.json` — bloc `serviceNume` complet
- [ ] `i18n/index.ts` — path mappings ambele direcții (CRITIC: necesar pentru hreflang + Language Switcher)
- [ ] Component `.astro` — secțiuni cu H2 question-based + lead paragraphs
- [ ] Page shell RO — Schema.org @graph (Service + FAQPage + BreadcrumbList + HowTo)
- [ ] Page shell EN — Mirror cu locale='en'
- [ ] FAQ selector unic (`data-[prefix]-faq-trigger`)
- [ ] `CLAUDE.md` — update: Ce s-a implementat, 404 table, structura, session history
- [ ] `npm run build` — zero erori
- [ ] Language Switcher — RO ↔ EN funcționează

> **Document complet**: `docs/SEO-AEO-GUIDELINES.md` — conține template-uri, exemple concrete, și checklist detaliat.

---

## 📱 RESPONSIVE DESIGN GUIDELINES

> **IMPLICIT pentru toate componentele**: Fiecare componentă nouă trebuie să respecte aceste reguli fără a fi nevoie să le specific de fiecare dată.

### Breakpoints (Tailwind CSS)

| Breakpoint | Prefix | Min Width | Utilizare |
|------------|--------|-----------|-----------|
| Mobile | (none) | 0px | Design implicit, mobile-first |
| SM | `sm:` | 640px | Telefoane mari, landscape |
| MD | `md:` | 768px | Tablete |
| LG | `lg:` | 1024px | Desktop |
| XL | `xl:` | 1280px | Desktop mare |
| 2XL | `2xl:` | 1536px | Ecrane foarte mari |

### Principii OBLIGATORII

1. **Mobile-First**: Stilurile de bază sunt pentru mobile, apoi adaugi pentru ecrane mai mari
2. **Testare pe toate breakpoints**: Verifică pe 375px, 768px, 1024px, 1440px
3. **Touch-friendly**: Butoanele/link-urile au minim 44x44px pe mobile
4. **Spațiere consistentă**: Folosește scale Tailwind (`p-4`, `p-6`, `p-8`)
5. **Font sizing responsive**: Text mai mic pe mobile, mai mare pe desktop

### Pattern-uri Standard

```css
/* Spacing responsive */
padding: 1rem;           /* Mobile */
@media (sm) padding: 1.5rem;
@media (lg) padding: 2rem;

/* Container max-width */
max-width: 100%;         /* Mobile - full width */
@media (lg) max-width: 1280px;  /* Desktop - constrained */

/* Grid responsive */
grid-cols-1              /* Mobile - 1 coloană */
sm:grid-cols-2           /* Tablet - 2 coloane */
lg:grid-cols-3           /* Desktop - 3 coloane */

/* Fixed elements (butoane, modals) */
position: fixed;
bottom: 1.5rem;          /* Mobile */
right: 1.5rem;
@media (lg) bottom: 2.5rem;
@media (lg) right: 2.5rem;
```

### Checklist Responsive (pentru fiecare componentă)

- [ ] Arată bine pe 375px (iPhone SE)
- [ ] Arată bine pe 768px (iPad)
- [ ] Arată bine pe 1024px (Desktop mic)
- [ ] Arată bine pe 1440px (Desktop standard)
- [ ] Textul e lizibil pe toate dimensiunile
- [ ] Butoanele sunt ușor de apăsat pe touch
- [ ] Imaginile se scalează corect
- [ ] Nu există overflow horizontal
- [ ] Animațiile nu crapă pe mobile

---

## 📚 DOCUMENTE CONEXE

| Document | Conține |
|----------|---------|
| `docs/STRATEGY.md` | Analiză competitivă detaliată, strategie diferențiere, design system Stripe |
| `docs/SEO-AEO-GUIDELINES.md` | **🔍 Reguli SEO & AEO obligatorii** — template-uri, Schema.org, checklist-uri |
| `docs/branding/BRANDING-NOTES.md` | Detalii logo, culori, tipografie |
| `docs/DEPLOYMENT.md` | Ghid deployment Vercel + Railway |
| `docs/MAINTENANCE.md` | Ghid mentenanță și actualizări, proceduri SEO audit |

---

## 🎬 SCALEWITHCONFIDENCE - ANIMAȚIE WAVE (DETALII TEHNICE)

> **Pentru AI**: Această secțiune conține specificațiile complete pentru animația wave. Citește-o înainte de orice modificare la ScaleWithConfidence.astro.

### Rolul AI pentru Animații

Când lucrezi la animații canvas/motion design, acționează ca:
- **Senior Frontend Engineer** + **Motion Designer**
- Cu experiență în animații canvas/WebGL
- Stil de referință: **Stripe / Linear / ElevenLabs**

### Conceptul Animației

Animația reprezintă **fluxuri de date** care:
1. **Pornesc din stânga** (input mare, volum)
2. **Se comprimă într-un punct central** (orchestrare / load balancing)
3. **Se redistribuie spre dreapta** (output stabil, controlat)

**CE TRANSMITE VIZUAL:**
- Scalare și throughput mare
- Flux stabil de date
- Orchestrare inteligentă
- Consistență sub sarcină mare

⚠️ **Animația NU este un gimmick vizual, ci un element de brand și UX.**

### Specificații Vizuale

| Element | Detalii |
|---------|---------|
| **Fundal** | Gradient dark: `#0a1628` → `#0f172a` → `#0a1628` |
| **Nr. linii** | 40-60 (35 pe mobile pentru performanță) |
| **Tip linie** | Curbe Bezier |
| **Gradient culori** | Portocaliu → Roz → Mov → Indigo → Albastru |
| **Fade** | Capetele wave-ului au opacity 0 (fade-out) |
| **Twist central** | Linii comprimate în centru, răsfirate la margini |

### Cerințe Tehnice OBLIGATORII

#### 1. Tehnologie
- **HTML Canvas 2D** (nu SVG, nu WebGL)
- Performanță stabilă pe **desktop și mobile**
- Fără jitter, fără flicker

#### 2. Canvas Setup
```javascript
// High-DPI support
const dpr = window.devicePixelRatio || 1;
canvas.width = rect.width * dpr;
canvas.height = rect.height * dpr;
ctx.setTransform(dpr, 0, 0, dpr, 0, 0);

// Resize corect la window resize
```

#### 3. Desenarea Liniilor
- Fiecare linie: index, poziție verticală relativă la centru, variație de fază
- Poziții cheie: **start** (stânga), **twist** (centru), **end** (dreapta)
- Curbe **convexe și fluide**, nu rigide
- **Asimetrie subtilă** - evită simetria perfectă

#### 4. Animație
- `requestAnimationFrame` pentru loop continuu
- Mișcare **lentă, calmă, "enterprise-safe"**
- Animația trebuie să pară "vie", nu matematică

#### 5. Control Animație (CRITIC)
```javascript
// IntersectionObserver - animația rulează DOAR când e vizibilă
const observer = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    if (entry.isIntersecting) {
      startAnimation();  // Pornește DOAR când vizibil
    } else {
      stopAnimation();   // Oprește când iese din viewport
    }
  });
}, { threshold: 0.1, rootMargin: '50px' });
```

#### 6. Reducerea Mișcării
```javascript
// Respectă preferințele utilizatorului
if (window.matchMedia('(prefers-reduced-motion: reduce)').matches) {
  // Desenează static, fără animație
}
```

### CE TREBUIE EVITAT

❌ `return` în script global care oprește execuția
❌ Pornirea multiplă a `requestAnimationFrame` (memory leak)
❌ Logică greu de urmărit
❌ Animații prea agresive sau "gaming-like"
❌ Simetrie perfectă
❌ Animații care crapă pe mobile

### TypeScript - Null Checks în Closures

**Problemă rezolvată**: TypeScript nu urmărește verificările null în funcții nested.

**Soluție**:
```typescript
// ❌ GREȘIT - TypeScript nu știe că ctx nu e null în funcții nested
const ctx = canvas.getContext('2d');
if (!ctx) return;
// ... în altă funcție, ctx e considerat posibil null

// ✅ CORECT - Reasignare explicită după verificare
const ctxNullable = canvas.getContext('2d');
if (!ctxNullable) return;
const ctx: CanvasRenderingContext2D = ctxNullable;
```

### Feeling Final Dorit

Când vezi animația, trebuie să simți:
- ✅ **Control**
- ✅ **Stabilitate**
- ✅ **Putere**
- ✅ **Încredere**
- ✅ **Tehnologie matură**

**Nu "wow effect", ci "this company knows what it's doing".**

### Parametri Ajustabili (CONFIG)

```javascript
const CONFIG = {
  lineCount: isMobile ? 35 : 50,      // Nr linii
  animationSpeed: 0.008,               // Viteza (mai mic = mai lent)
  spreadStart: 70,                     // Deschidere la start
  spreadTwist: 8,                      // Compresie la twist
  spreadEnd: 90,                       // Deschidere la end
  bulgeFactor: 60,                     // Cât de mult "ies" liniile
  waveAmplitude: 25,                   // Amplitudinea undelor
  waveFrequency: 0.8,                  // Frecvența undelor
};
```

---

## ⚡ REGULI PENTRU ANIMAȚII (TOATE COMPONENTELE)

> **CRITIC**: Orice animație trebuie să respecte aceste reguli pentru a nu crăpa site-ul.

### 1. Performanță pe Toate Dispozitivele
- Testează pe mobile (Android + iOS)
- Reduce complexitatea pe dispozitive low-power
- Folosește `will-change` cu moderație

### 2. Respectă Preferințele Utilizator
```css
@media (prefers-reduced-motion: reduce) {
  /* Dezactivează sau reduce animațiile */
}
```

### 3. Animații Condiționate de Vizibilitate
- Folosește `IntersectionObserver` pentru a porni/opri
- NU lăsa animații să ruleze în background (battery drain)

### 4. Cleanup la Navigare (SPA)
```javascript
document.addEventListener('astro:before-preparation', () => {
  stopAnimation();
  observer.disconnect();
});
```

### 5. Error Handling
- Verifică dacă canvas/context există înainte de a desena
- Graceful degradation pe browsere vechi

---

## 🍪 COOKIE BANNER - DESIGN GUIDELINES (2025-2026)

> **Pentru AI**: Această secțiune conține specificațiile pentru Cookie Banner modern și GDPR-compliant.

### Principii de Design Modern

**Surse de referință**:
- https://secureprivacy.ai/blog/cookie-banner-design-2026
- https://cookieinformation.com/blog/designing-compliant-cookie-banners/
- https://www.enzuzo.com/learn/best-cookie-banner-examples

### Caracteristici Implementate

| Aspect | Descriere |
|--------|-----------|
| **Stil** | Corner popup (colț stânga-jos) - nu blochează conținutul |
| **Dimensiune** | Compact: max-width 320px (400px pe tablet+) |
| **Poziție** | Fixed, bottom-left cu margini responsive |
| **Animație** | Fade-in subtil cu scale + translateY |
| **Button parity** | GDPR compliant - butoanele au aceeași dimensiune vizuală |

### GDPR Compliance - Reguli OBLIGATORII

1. **Button Parity** (Paritate butoane):
   - Butoanele "Accept" și "Refuz/Decline" TREBUIE să aibă aceeași dimensiune
   - NU se permite "Accept" mare și "Decline" mic/ascuns
   - Culori diferite sunt OK, dar dimensiunea trebuie egală

2. **No Dark Patterns**:
   - NU ascunde opțiunea de refuz
   - NU face dificilă respingerea cookie-urilor
   - NU pre-bifează checkbox-uri pentru marketing

3. **Clear Language**:
   - Text scurt, ușor de înțeles
   - Evită jargon legal excesiv

### Specificații Tehnice

```css
/* Poziție - Corner popup stânga-jos */
.cookie-banner {
  position: fixed;
  bottom: 1rem;      /* 1.5rem pe tablet, 2rem pe desktop */
  left: 1rem;        /* 1.5rem pe tablet, 2rem pe desktop */
  z-index: 50;
  max-width: 320px;  /* 400px pe tablet+ */
}

/* Animație - Subtle fade in */
.cookie-banner {
  opacity: 0;
  visibility: hidden;
  transform: translateY(1rem) scale(0.95);
  transition: opacity 0.3s, visibility 0.3s, transform 0.3s;
}

.cookie-banner.visible {
  opacity: 1;
  visibility: visible;
  transform: translateY(0) scale(1);
}

/* Butoane - EGAL visual weight */
.cookie-btn {
  flex: 1;  /* Ambele butoane ocupă spațiu egal */
  padding: 0.625rem 1rem;
  font-size: 0.875rem;
}
```

### Funcționalitate JavaScript

```javascript
// Cookie name și duration
const COOKIE_NAME = 'generativa_cookie_consent';
const COOKIE_DURATION = 365; // days

// Valori posibile
// 'accepted' - utilizatorul a acceptat
// 'rejected' - utilizatorul a refuzat

// Event dispatch pentru alte componente
window.dispatchEvent(new CustomEvent('cookieBannerHidden'));
```

### Integrare cu ScrollToTop

Cookie Banner și ScrollToTop sunt coordonate inteligent pe baza dimensiunii ecranului:

| Dispozitiv | Comportament ScrollToTop |
|------------|--------------------------|
| **Mobile (<640px)** | Așteaptă cookie banner dismiss (evită suprapunere) |
| **Desktop/Tablet (≥640px)** | Apare imediat când scrollezi 400px (nu se suprapun) |

**Logica**:
- Pe mobile, spațiul e limitat → ambele elemente pot să se suprapună
- Pe desktop, cookie banner e în stânga-jos, ScrollToTop în dreapta-jos → nu se suprapun
- Se folosește custom event `cookieBannerHidden` pentru comunicare
- Resize listener actualizează comportamentul la schimbarea viewport-ului

### Responsive Breakpoints

| Breakpoint | Banner Width | Position |
|------------|--------------|----------|
| Mobile (<400px) | calc(100% - 2rem) max 320px | bottom: 1rem, left: 1rem |
| Tablet (≥400px) | max 400px | bottom: 1.5rem, left: 1.5rem |
| Desktop (≥640px) | max 400px | bottom: 1.5rem, left: 1.5rem |
| Large (≥1024px) | max 400px | bottom: 2rem, left: 2rem |

### Accessibility

- `role="dialog"` pentru screen readers
- `aria-labelledby` și `aria-describedby` pentru context
- Focus visible pe butoane
- Reduced motion support

---

## 📱 MOBILE OPTIMIZATION - HORIZONTAL SCROLL (Februarie 2026)

> **Pentru AI**: Această secțiune documentează optimizările pentru mobile care reduc scroll-ul vertical prin scroll orizontal pentru carduri.

### Principiul de Bază

Pe mobile (sub 768px), secțiunile cu multiple carduri folosesc **scroll orizontal** în loc de grid vertical pentru a reduce cantitatea de scroll necesară până la finalul paginii.

### Componente Optimizate

| Component | Optimizare | Breakpoint |
|-----------|-----------|------------|
| **UseCases** | 6 carduri → scroll orizontal cu dots | `md:` (768px) |
| **BenefitsStrip** | 6 beneficii → scroll orizontal compact | `md:` (768px) |
| **AboutPage Approach** | 4 carduri → scroll orizontal | `md:` (768px) |
| **AboutPage WhyUs** | 4 carduri → scroll orizontal | `md:` (768px) |
| **IntegrationHub** | Layout simplificat + scroll orizontal | `md:` (768px) |
| **IntegrationHub Benefits** | 4 beneficii → scroll orizontal | `md:` (768px) |

### Pattern-uri CSS Folosite

```css
/* Container scroll orizontal */
.scroll-container {
  display: flex;
  gap: 0.75rem;              /* gap-3 */
  overflow-x: auto;
  padding-bottom: 1rem;      /* pb-4 pentru scrollbar */
  scroll-snap-type: x mandatory;
  -webkit-overflow-scrolling: touch;  /* iOS smooth scroll */
}

/* Card în scroll */
.scroll-card {
  flex-shrink: 0;
  width: 280px;              /* sau w-[85vw] pentru full-width */
  scroll-snap-align: start;
}

/* Ascunde scrollbar dar păstrează funcționalitatea */
.scrollbar-hide {
  -ms-overflow-style: none;
  scrollbar-width: none;
}
.scrollbar-hide::-webkit-scrollbar {
  display: none;
}

/* Extend scroll area pentru edge-to-edge */
.extend-scroll {
  margin-left: -1rem;
  margin-right: -1rem;
  padding-left: 1rem;
  padding-right: 1rem;
}
```

### Tailwind Classes Standard

```html
<!-- Container -->
<div class="flex md:grid md:grid-cols-3 gap-4 overflow-x-auto md:overflow-visible
            pb-4 md:pb-0 snap-x snap-mandatory scrollbar-hide -mx-4 px-4 md:mx-0 md:px-0">

  <!-- Card -->
  <div class="flex-shrink-0 w-[280px] md:w-auto snap-start">
    <!-- content -->
  </div>
</div>
```

### Dynamic Scroll Arrows (Pattern Standard)

Săgețile de scroll sunt **dinamice** — arată doar direcția în care se poate scrola:

```html
<!-- Indicator dinamic (mobile only) -->
<div class="flex md:hidden items-center justify-center gap-2 text-xs text-neutral-400 mb-3" data-scroll-hint>
  <svg class="w-4 h-4 transition-opacity duration-300 opacity-0" data-arrow-left><!-- left chevron --></svg>
  <span data-hint-text>Glisează pentru mai multe</span>
  <svg class="w-4 h-4 animate-pulse transition-opacity duration-300" data-arrow-right><!-- right chevron --></svg>
</div>

<!-- Container cu data-scroll-container -->
<div class="flex md:grid ... overflow-x-auto ... snap-x snap-mandatory" data-scroll-container>
  <!-- cards -->
</div>
```

```javascript
// Script: actualizează săgețile pe scroll
function updateArrows() {
  const { scrollLeft, scrollWidth, clientWidth } = container;
  const atStart = scrollLeft <= 10;
  const atEnd = scrollLeft + clientWidth >= scrollWidth - 10;

  arrowLeft.style.opacity = atStart ? '0' : '1';
  arrowLeft.classList.toggle('animate-pulse', !atStart);
  arrowRight.style.opacity = atEnd ? '0' : '1';
  arrowRight.classList.toggle('animate-pulse', !atEnd);
}
container.addEventListener('scroll', updateArrows, { passive: true });
```

**Comportament:**
| Poziție | Săgeata stânga | Săgeata dreapta |
|---------|----------------|-----------------|
| La început | Invizibilă | ✅ Pulsează |
| La mijloc | ✅ Pulsează | ✅ Pulsează |
| La final | ✅ Pulsează | Invizibilă |

**Pagini cu pattern aplicat**: Services, UseCases (homepage), ProcessAutomation, ConversationalAgents (2x), AiIntegrations (2x)

### Dot Indicators (UseCases)

```html
<!-- Indicatori pentru poziția curentă -->
<div class="flex md:hidden justify-center gap-2 mt-4">
  {items.map((_, index) => (
    <div class="scroll-indicator w-2 h-2 rounded-full bg-slate-300
                transition-colors duration-300 [&.active]:bg-primary-500" />
  ))}
</div>

<script>
  // Update indicators on scroll
  container.addEventListener('scroll', () => {
    const activeIndex = Math.round(scrollLeft / cardWidth);
    indicators.forEach((el, i) => el.classList.toggle('active', i === activeIndex));
  });
</script>
```

### Mobile-Specific Layouts

**IntegrationHub pe Mobile:**
- Hub central mic (w-28 h-28) în loc de w-44 h-44
- Conexiuni în scroll orizontal (carduri mici w-20)
- Grid complex ascuns (`hidden md:block`)

**BenefitsStrip pe Mobile:**
- Descrierile ascunse (`hidden md:block`)
- Iconuri mai mici (w-8 h-8 vs w-10 h-10)
- Text mai mic (text-xs vs text-sm)

### Reguli OBLIGATORII

1. **Adaugă `.scrollbar-hide`** la fiecare container cu scroll orizontal
2. **Folosește `snap-x snap-mandatory`** pentru snapping la carduri
3. **Extinde cu `-mx-4 px-4`** pentru edge-to-edge scroll pe mobile
4. **Resetează pe desktop** cu `md:overflow-visible md:mx-0 md:px-0`
5. **Testează pe iOS** - folosește `-webkit-overflow-scrolling: touch`

---

## 🐛 KNOWN BUGS & TESTING LOG

> **Pentru AI**: Această secțiune documentează bug-urile găsite și rezolvate. Verifică întotdeauna aceste elemente când faci modificări.

### Bug-uri Rezolvate ✅

| Data | Bug | Cauză | Soluție |
|------|-----|-------|---------|
| Feb 2026 | Language Switcher returnează 404 când schimbi din EN în RO | Path-urile diferă între limbi (`/en/about/` vs `/ro/despre/`). Simple `replace` nu funcționa. | Creat `buildAlternatePath()` în i18n cu path mappings între limbi |
| Feb 2026 | Cookie Banner butoane nu funcționau | Button.astro nu trecea `data-*` attributes la HTML element | Adăugat `...rest` spread în Button component |
| Feb 2026 | ScrollToTop se suprapunea cu CookieBanner pe mobile | Ambele elemente în colțul dreapta-jos | ScrollToTop așteaptă cookie dismiss pe mobile, apare imediat pe desktop |
| Feb 2026 | Mobile menu (hamburger) nu se deschidea | Event listeners nu se atașau corect, Astro SPA mode | Adăugat DOMContentLoaded + astro:page-load listeners, clonare buton |
| Feb 2026 | Text invizibil pe secțiuni dark (About page) | Titlurile din secțiunile Mission și Stats nu aveau `text-white` explicit | Adăugat `text-white` la toate titlurile pe fundaluri dark |
| Feb 2026 | Favicon în tab Chrome arăta vechiul logo SVG | Commit `1080d32` a revenit favicon.svg la SVG vechi, dar `3cf64f3` nu l-a restaurat | Generate PNG favicons (32x32, 16x16) din noul logo, actualizat BaseLayout |
| Feb 2026 | IntegrationHub labels invizibile pe mobile | Label-urile aveau `hidden sm:block` — ascunse pe mobile | Schimbat la `block` pe toate dimensiunile |
| Feb 2026 | Logo rollback greșit — revenit TOTAL la SVG | La "rollback" s-a presupus revert total, dar utilizatoarea voia doar eliminarea cercului gri | Restaurat PNG logo din commit anterior (`d86a3cd`) |

### Link-uri care duc la 404 (Pagini neimplementate) ⚠️

Aceste link-uri există în Header/Footer dar paginile NU sunt create încă:

| Link | Path RO | Path EN | Status |
|------|---------|---------|--------|
| **Servicii dropdown** | `/ro/servicii/` | `/en/services/` | ✅ Redirect la homepage /#services |
| Automatizare Procese | `/ro/servicii/automatizare-procese/` | `/en/services/process-automation/` | ✅ Implementat |
| Agenți Conversaționali | `/ro/servicii/agenti-conversationali/` | `/en/services/conversational-agents/` | ✅ Implementat |
| Integrări AI | `/ro/servicii/integrari-ai/` | `/en/services/ai-integrations/` | ✅ Implementat |
| ~~Blog~~ | ~~`/ro/blog/`~~ | ~~`/en/blog/`~~ | ✅ Eliminat din Header (pagini goale = SEO negativ) |
| Studii de caz | `/ro/studii-caz/` | `/en/case-studies/` | ❌ Nu există (nu e linkuit nicăieri) |
| Politica confidențialitate | `/ro/politica-confidentialitate/` | `/en/privacy-policy/` | ✅ Implementat |
| Termeni și condiții | `/ro/termeni-conditii/` | `/en/terms-conditions/` | ✅ Implementat |

### Elemente de Verificat la Fiecare Modificare

1. **Language Switcher** - Verifică traducerea path-urilor între limbi
2. **Header navigation** - Link-urile funcționează corect
3. **Footer navigation** - Link-urile funcționează corect
4. **Mobile menu** - Se deschide/închide corect
5. **CTA buttons** - Duc la paginile corecte
6. **Cookie Banner** - Funcționează pe toate dispozitivele
7. **ScrollToTop** - Apare corect pe mobile și desktop
8. **Responsive** - Testează pe 375px, 768px, 1024px, 1440px
9. **Contrast text pe dark sections** - Verifică că textul e vizibil pe fundaluri închise

### ⚠️ REGULI CONTRAST TEXT PE FUNDALURI DARK

> **FOARTE IMPORTANT**: Această greșeală s-a repetat de mai multe ori. AI-ul TREBUIE să verifice automat!

Când creezi sau modifici secțiuni cu fundal dark (`bg-slate-900`, `bg-gradient-to-br from-slate-900`, etc.):

1. **TOATE titlurile** trebuie să aibă `text-white` EXPLICIT
2. **Paragrafele** trebuie să aibă `text-slate-300` sau `text-slate-400`
3. **NU te baza** pe `text-white` la nivel de section - nu se moștenește întotdeauna

**Exemplu CORECT:**
```html
<section class="bg-gradient-to-br from-slate-900 via-slate-800 to-indigo-950">
  <h2 class="text-white">Titlu</h2>  <!-- EXPLICIT text-white -->
  <p class="text-slate-300">Conținut</p>
</section>
```

**Exemplu GREȘIT:**
```html
<section class="bg-slate-900 text-white">  <!-- text-white la section NU e suficient -->
  <h2>Titlu</h2>  <!-- poate fi invizibil! -->
</section>
```

**Secțiuni afectate (verifică întotdeauna):**
- IntegrationHub (homepage)
- ScaleWithConfidence (homepage)
- Mission section (About page)
- Stats section (About page)
- Footer
- Orice altă secțiune cu gradient dark

### Path Mappings pentru Language Switcher

Când adaugi o pagină nouă, actualizează `pathMappings` în `src/i18n/index.ts`:

```typescript
const pathMappings: Record<string, Record<Locale, string>> = {
  'despre': { ro: 'despre', en: 'about' },
  'about': { ro: 'despre', en: 'about' },
  'contact': { ro: 'contact', en: 'contact' },
  'servicii': { ro: 'servicii', en: 'services' },
  'services': { ro: 'servicii', en: 'services' },
  'blog': { ro: 'blog', en: 'blog' },
  // Service sub-pages
  'automatizare-procese': { ro: 'automatizare-procese', en: 'process-automation' },
  'process-automation': { ro: 'automatizare-procese', en: 'process-automation' },
  'agenti-conversationali': { ro: 'agenti-conversationali', en: 'conversational-agents' },
  'conversational-agents': { ro: 'agenti-conversationali', en: 'conversational-agents' },
  'integrari-ai': { ro: 'integrari-ai', en: 'ai-integrations' },
  'ai-integrations': { ro: 'integrari-ai', en: 'ai-integrations' },
  // Adaugă mapări noi aici!
};
```

---

## 🔄 ISTORIC SESIUNI

### Sesiune Februarie 2026 - Redesign Major
- Analiză competitivă (Agentic.ro, Inflate.agency)
- Strategie "Demo-First + Storytelling"
- Implementare HeroInteractive cu ChatSimulator
- Creare BenefitsStrip, UseCases, IntegrationHub
- Redesign IntegrationHub stil Stripe (gradient dark, glassmorphism, linii animate)

### Sesiune Februarie 2026 - ScaleWithConfidence
- Creare animație wave Canvas pentru secțiunea "Scale with confidence"
- Concept: fluxuri de date care se comprimă și redistribuie
- Fix TypeScript null checks în closures pentru canvas
- Documentare completă a specificațiilor pentru animații

### Sesiune Februarie 2026 - ScrollToTop & Cookie Banner Redesign
- Creare buton ScrollToTop cu brand gradient (cyan→purple)
- Fix suprapunere ScrollToTop cu CookieBanner pe mobile
- Implementare comunicare între componente via custom event `cookieBannerHidden`
- Fix Button.astro pentru a suporta `data-*` attributes
- Redesign complet CookieBanner: corner popup modern, GDPR compliant
- Documentare Cookie Banner design guidelines (2025-2026 best practices)
- **Optimizare**: ScrollToTop apare imediat pe desktop (≥640px), așteaptă cookie doar pe mobile

### Sesiune Februarie 2026 - Hero Stats Redesign
- Redesign complet al statisticilor din Hero (0.8s, 24/7, 90%)
- Carduri cu glassmorphism (bg-white/60, backdrop-blur, border subtil)
- Iconițe relevante pentru fiecare stat (bolt, clock, check)
- Separare value/unit pentru ierarhie vizuală
- Counter animation (numere care "numără" de la 0 când intră în view)
- Hover effects: lift (-2px), shadow glow, icon pulse
- IntersectionObserver pentru declanșare animație
- Stagger effect (150ms delay între carduri)

### Sesiune Februarie 2026 - Pagina Despre & Bug Fixes
- **Pagina Despre** creată (`/ro/despre/`, `/en/about/`)
  - Conținut original optimizat SEO și marketing
  - Storytelling compelling despre povestea companiei
  - Secțiuni: Hero, Story, Mission, Approach, Why Us, Stats, CTA
  - Design modern cu alternanță light/dark
- **Bug Fix**: Language Switcher 404
  - Creat sistem de path mappings în i18n
  - Funcție `buildAlternatePath()` pentru traducere corectă
- **Audit de bugs** și documentare în CLAUDE.md
  - Listat toate link-urile care duc la 404
  - Checklist pentru verificări la modificări
  - Secțiune dedicată pentru known bugs

### Sesiune Februarie 2026 - Mobile Optimization (Scroll Orizontal)
- **Problema**: Pe mobile, scroll-ul vertical era prea lung până la finalul paginii
- **Soluția**: Cardurile din secțiuni se derulează orizontal pe mobile
- **Componente optimizate**:
  - UseCases: scroll orizontal cu dots indicators și swipe hint
  - BenefitsStrip: compact pe mobile, descrieri ascunse, iconuri mici
  - AboutPage Approach: carduri în scroll orizontal
  - AboutPage WhyUs: carduri în scroll orizontal
  - IntegrationHub: layout simplificat cu hub central mic + conexiuni scroll
  - IntegrationHub Benefits: scroll orizontal pe mobile
- **Pattern CSS**: `flex md:grid overflow-x-auto md:overflow-visible snap-x scrollbar-hide`
- **Fix TypeScript**: `container` null check în UseCases scroll handler

### Sesiune Februarie 2026 - Backend Email & Infrastructure Fix
- **Problema principală**: Emailurile din formularul de contact nu se trimiteau
- **Cauze identificate** (multiple):
  1. Railway blochează SMTP outbound (porturi 25, 465, 587) — testat cu mail.generativa.ro și smtp.resend.com
  2. Email se trimitea sincron → pagina bloca 4+ minute
  3. Lipsea PostgreSQL — app-ul rula pe H2 in-memory (date pierdute la restart)
  4. Railway deploy-uri eșuau (lipsea configurație build)
  5. Health endpoint DOWN din cauza MailHealthIndicator
- **Soluții implementate**:
  1. **Resend HTTP API** în loc de SMTP (port 443 HTTPS, mereu disponibil) — vezi secțiunea dedicată
  2. **@Async + @EnableAsync** pentru trimitere email în background (~0.5s response)
  3. **PostgreSQL addon** pe Railway + `SPRING_PROFILES_ACTIVE=prod`
  4. **nixpacks.toml** + **Procfile** pentru build configuration
  5. **Mail health indicator dezactivat** (`management.health.mail.enabled=false`)
  6. **processed/processed_at** se actualizează după trimiterea emailurilor
  7. **Confirmarea user** se trimite doar dacă notificarea admin a reușit
  8. **Mesaj succes auto-hide** după 5 secunde în formularul de contact
- **Resend.com setup**:
  - Cont creat cu GitHub OAuth
  - Domeniu `generativa.ro` verificat (DKIM + SPF)
  - DNS records adăugate în cPanel Zone Editor (Hosterion)
  - API Key stocat ca `MAIL_PASSWORD` pe Railway
- **Railway CLI** instalat (`@railway/cli` via npm) pentru management variabile
- **Commits pe main**: 7 commits (`0319b7f` → `cf0490e`)
- **Merge main → staging** efectuat pentru sincronizare

### Sesiune Februarie 2026 - Pagina Automatizare Procese (SEO/AEO)
- **Prima pagină de serviciu** creată (`/ro/servicii/automatizare-procese/`, `/en/services/process-automation/`)
- **6 secțiuni**: Hero cu breadcrumb, Ce automatizăm (6 carduri), Cum abordăm (timeline vertical dark), Beneficii (5 metric cards), FAQ (6 Q&A accordion), CTA dark
- **SEO/AEO optimizat**:
  - Question-based H2 headings matching People Also Ask queries
  - Answer-first lead paragraphs (40-60 words) for Featured Snippets & AI Overviews
  - Schema.org `@graph` cu 4 scheme: Service, FAQPage, BreadcrumbList, HowTo
  - Meta tags optimizate (title 46 chars, description 148 chars)
  - FAQ section targetând întrebări reale (cost, durată, ROI, angajați)
- **Pattern**: Urmează exact AboutPage.astro (locale prop, alternating light/dark, mobile scroll)
- **Path mappings**: `automatizare-procese` ↔ `process-automation` pentru Language Switcher
- **Fișiere**: 4 create, 3 modificate (ro.json, en.json, i18n/index.ts)

### Sesiune Februarie 2026 - Site-wide SEO/AEO Audit & Agenți Conversaționali Page
- **Audit SEO complet** pe toate paginile existente
  - Homepage RO/EN: Fix domain URLs (`diginest.ai` → `diginest-ai-platform.vercel.app`), upgrade la `@graph` cu WebSite + WebPage + BreadcrumbList
  - About RO/EN: Adăugat schema AboutPage + Organization (foundingDate, knowsAbout) + BreadcrumbList
  - Contact RO/EN: Adăugat schema ContactPage + ContactPoint (email, languages) + BreadcrumbList
  - FAQ inline schema verificat — fără duplicare (homepage și service pages au FAQ-uri separate)
- **A doua pagină de serviciu** creată (`/ro/servicii/agenti-conversationali/`, `/en/services/conversational-agents/`)
- **7 secțiuni** (una în plus față de Automatizare): Hero, Capabilități (6 carduri), Cum funcționează (timeline 4 pași), Industrii (6 carduri cu problem→solution), Beneficii (5 metric cards), FAQ (8 Q&A accordion), CTA
- **SEO/AEO optimizat**:
  - Question-based H2 headings targetând People Also Ask RO/EN
  - Answer-first lead paragraphs (40-60 words) pentru Featured Snippets & AI Overviews
  - Schema.org `@graph` cu 4 scheme: Service (cu hasOfferCatalog Voice/Chat/Email), FAQPage (8 items), BreadcrumbList, HowTo
  - Meta tags optimizate (RO title 66 chars, EN title 70 chars)
  - 8 FAQ items targetând întrebări reale (cost vs receptioner, limba română, integrări, înlocuire angajați, escalare, durată, industrii, GDPR)
- **FAQ selector unic**: `data-conv-faq-trigger` (diferit de `data-faq-trigger` homepage și `data-service-faq-trigger` automatizare)
- **Industrii cu problem→solution**: Call Center, Clinici Medicale, Hospitality, Utilities/Telecom, Beauty/SPA, Service Auto
- **Path mappings**: `agenti-conversationali` ↔ `conversational-agents` pentru Language Switcher
- **Fișiere**: 4 create, 5 modificate (ro.json, en.json, i18n/index.ts, + 6 page shells pentru SEO audit)

### Sesiune Februarie 2026 - UX Cleanup, Form Validation & Lead Qualification
- **Fix 404 Servicii**: Link-ul "Servicii" din Header dropdown + breadcrumb-urile service pages redirect la homepage `/#services` (scroll) în loc de pagină separată. Eliminat `ServicesPage.astro` (redundantă cu Services section de pe homepage). Actualizat breadcrumb Schema.org în toate 6 page shells.
- **Eliminat Blog & Resources**:
  - Scos link Blog din Header navigation
  - Scos secțiunea Resurse din Footer (grid ajustat 5→4 coloane)
  - Motivație documentată: paginile goale dăunează SEO la business nou (crawl budget waste, bounce rate, thin content signals)
- **Custom Form Validation** (ContactForm.astro rewrite):
  - `novalidate` pe form + validare JS completă cu mesaje locale-aware (RO/EN)
  - Inline error messages per câmp cu stil vizual (border roșu, mesaj sub input)
  - Validare email: regex comprehensive
  - Validare telefon: E.164 standard (7-15 cifre), caractere permise: `+`, cifre, spații, `-`, `.`, `(`, `)`
  - Validare pe `input`/`change` events (real-time clear) + `blur` (validate on leave)
  - Mesaje traduse în `contact.form.validation` din ro.json/en.json
- **Lead Qualification Dropdowns** (Industry + Interest):
  - **Industry** (8 opțiuni): Clinică dentară, Cabinet medical, Salon beauty/SPA, Service auto, HoReCa, Retail/E-commerce, Rețea multi-locații, Altele
  - **Interest** (4 opțiuni): Automatizare procese, Agenți conversaționali, Integrări AI, Nu sunt sigur
  - Dropdown-uri required cu validare custom
  - **Backend compatibility fără modificări**: Industry label + Interest label se prepend la mesaj
    ```
    [Industrie: Clinică dentară]
    [Interes: Automatizare procese]

    <mesajul utilizatorului>
    ```
  - Backend DTO/entity/DB **nemodificate** — evitat deploy backend
- **Commits**: `7ccbf32`, `f661340`, `75fdc42`, `5f36a1b` (toate pe staging)

### Sesiune Februarie 2026 - Unificare ScaleWithConfidence + Benefits
- **Problema**: Două secțiuni dark consecutive pe homepage (ScaleWithConfidence + Benefits) comunicau redundant metrici de performanță (`24/7` apărea în ambele)
- **Soluția**: Eliminat secțiunea Benefits separată, cardurile business (70%, 24/7, 10x, 300%) integrate direct sub animația wave în ScaleWithConfidence
- **Fișiere modificate**: `ScaleWithConfidence.astro` (adăugat i18n + benefits cards, eliminat stats mici), `ro/index.astro` + `en/index.astro` (eliminat `<Benefits />`)
- **Benefits.astro** păstrat în codebase (nefolosit pe homepage) — poate fi reutilizat dacă e nevoie
- Homepage: 9 secțiuni (anterior 10)

### Sesiune Februarie 2026 - Pagini Legale (Privacy Policy + Terms & Conditions)
- **Două pagini legale** create, GDPR-compliant:
  - Politica de Confidențialitate (`/ro/politica-confidentialitate/`, `/en/privacy-policy/`) — 12 secțiuni + Cookie Policy (5 secțiuni)
  - Termeni și Condiții (`/ro/termeni-conditii/`, `/en/terms-conditions/`) — 10 secțiuni
- **Companie**: DIGITAL LEADERSHIP SRL, CUI 38585123, J12/6715/2017, Dezmir, Cluj
- **Conținut legal acoperă**: colectare date, temeiuri GDPR (art. 6), drepturi utilizator, securitate date, transfer UE/SEE, ANSPDCP, proprietate intelectuală, limitarea răspunderii, legislație română aplicabilă
- **Schema.org**: WebPage + BreadcrumbList per pagină (pattern @graph)
- **Path mappings**: `politica-confidentialitate` ↔ `privacy-policy`, `termeni-conditii` ↔ `terms-conditions`
- **Footer actualizat**: Înlocuit placeholder company info cu datele reale DIGITAL LEADERSHIP SRL
- **Fișiere create**: 4 page shells + 2 componente (`PrivacyPolicyPage.astro`, `TermsConditionsPage.astro`)
- **Fișiere modificate**: `ro.json`, `en.json` (traduceri legale), `i18n/index.ts` (path mappings), `Footer.astro` (company info)

### Sesiune Februarie 2026 - Hreflang Fix & Organization Schema
- **Problema 1**: Hreflang tags din `BaseLayout.astro` foloseau `String.replace()` simplu care NU traducea path-urile (ex. `/ro/despre/` → `/en/despre/` în loc de `/en/about/`)
- **Problema 2**: `x-default` pointea la `/en/` (greșit — publicul principal e românesc)
- **Problema 3**: Organization schema avea adresă placeholder (București) în loc de adresa reală
- **Soluții implementate**:
  1. Înlocuit `currentPath.replace()` cu `buildAlternatePath()` din `i18n/index.ts` — translatează corect path-urile între limbi
  2. `x-default` → versiunea RO a paginii curente (nu mai e hardcodat la homepage)
  3. Organization schema actualizat: adresă reală (Dezmir, Cluj), `legalName: DIGITAL LEADERSHIP SRL`, `taxID: 38585123`
- **Verificare**: Build HTML confirmat — hreflang generat corect pentru toate paginile (`/ro/despre/` ↔ `/en/about/`, `/ro/politica-confidentialitate/` ↔ `/en/privacy-policy/`)
- **Fișiere modificate**: `BaseLayout.astro`, `SEO-AEO-GUIDELINES.md`, `CLAUDE.md`

### Sesiune Februarie 2026 - Language Switcher Redesign
- **Problema**: LanguageSwitcher arăta ca un link simplu cu emoji flag + text — nu se integra vizual cu brandul
- **Soluția**: Toggle pill compact cu gradient brand (RO | EN)
- **Design**:
  - Container: `rounded-full bg-neutral-100 border border-neutral-200/80 p-0.5`
  - Limba activă: `bg-gradient-to-r from-primary-500 to-accent-600 text-white rounded-full shadow-sm`
  - Limba inactivă: `text-neutral-500 hover:text-neutral-700` — link clickable
  - Labels: "RO" / "EN" — fără emoji flags (best practice 2025: flags = țări, nu limbi)
- **Accessibility**: `role="navigation"`, `aria-label`, `aria-current="true"` pe limba activă, `lang` attribute pe fiecare label
- **Fișiere modificate**: `LanguageSwitcher.astro` (rewrite complet)

### Sesiune Februarie 2026 - Services Mobile Scroll
- **Problema**: Cardurile servicii ocupau prea mult spațiu vertical pe mobile
- **Soluția**: Scroll orizontal pe mobile cu snap-to-card
- **Pattern CSS**: `flex md:grid md:grid-cols-3 overflow-x-auto md:overflow-visible snap-x snap-mandatory scrollbar-hide -mx-4 px-4 md:mx-0 md:px-0`
- **Carduri**: `flex-shrink-0 w-[280px] md:w-auto snap-start`
- **Swipe hint**: Vizibil doar pe mobile (`flex md:hidden`)
- **Commit**: `3d94aa1`

### Sesiune Februarie 2026 - Logo Redesign (SVG → PNG 3D)
- **Context**: Utilizatoarea nu a fost mulțumită de logo-ul SVG vechi și a vrut să folosească o imagine AI-generated
- **Proces** (multiple iterații):
  1. Prima încercare SVG recreation → respins ("departe de ceea ce vreau eu")
  2. PNG cu text complet → respins (prea mic, text duplicat, noduri invizibile pe alb)
  3. Cropped doar G-ul → utilizatoarea a oferit altă imagine mai bună
  4. `Image (5).jpg` — G 3D glossy cyan-blue pe fundal gri → procesat cu Sharp
  5. Background removal: pixel-by-pixel (RGB > 210, channels within 15) → alpha=0
  6. Gray circle behind logo → respins ("rollback nu imi place")
  7. **GREȘEALĂ CRITICĂ**: Am făcut rollback TOTAL la SVG (commit `1080d32`) când utilizatoarea voia doar eliminarea cercului gri
  8. Restaurare PNG fără cerc (commit `3cf64f3`)
- **Fișiere finale**:
  - `public/images/generativa-g-512.png` — logo principal (512x512, transparent)
  - `public/images/generativa-g-200.png` — versiune mică
  - `Logo.astro` — rescris complet pentru PNG (`<img>` în loc de inline SVG)
- **Lecție învățată**: La "rollback" clarifică EXACT ce se dorește revertat, nu presupune
- **Commits**: `4376f0c`, `5f454a8`, `d86a3cd`, `55066a2`, `1080d32` (greșit), `3cf64f3` (fix)

### Sesiune Februarie 2026 - Header Gradient & Ambient Color Tones
- **Problema**: Header-ul era `bg-white/80` — complet alb, fără nuanțe de brand
- **Ce dorea utilizatoarea**: Nuanțe subtile de cyan/lavender vizibile în header (ca pe mobile cu blur)
- **Soluție în 2 pași**:
  1. **Ambient blobs** în `BaseLayout.astro` — `pointer-events-none fixed inset-0 z-0`:
     - `w-[500px] h-[500px] bg-primary-200/25 blur-3xl` (stânga-sus)
     - `w-[450px] h-[450px] bg-accent-200/20 blur-3xl` (dreapta-sus)
     - `w-96 h-96 bg-primary-100/25 blur-3xl` (mijloc)
  2. **Header gradient** în `Header.astro`:
     - `bg-gradient-to-r from-primary-50/80 via-white/80 to-accent-50/60` (înlocuiește `bg-white/80`)
     - Păstrat `backdrop-blur-lg border-b border-neutral-200/50`
- **Main** content are `relative z-10` pentru a fi deasupra blob-urilor
- **Commits**: `6216a87` (blobs), `f112d34` (header gradient + blobs mari)

### Sesiune Februarie 2026 - IntegrationHub Mobile Labels + Favicon PNG
- **IntegrationHub**: Label-urile conexiunilor (Apeluri telefonice, WhatsApp, etc.) erau `hidden sm:block` → schimbate la `block` pentru vizibilitate pe toate dimensiunile. Text `9px` pe mobile, `10px` pe sm, `12px` pe md+
- **Favicon**: Tab-ul Chrome arăta încă vechiul SVG logo. Generate PNG favicons cu Sharp din logo-ul 3D:
  - `favicon-32.png` (32x32) — favicon principal
  - `favicon-16.png` (16x16) — favicon mic
  - `apple-touch-icon.png` (180x180) — iOS
  - `BaseLayout.astro` actualizat: eliminat `<link rel="icon" type="image/svg+xml" href="/favicon.svg">`
- **Commits**: `61cf091` (labels), `0b42564` (favicon)

### Sesiune Februarie 2026 - CTA Redesign, Spacing & Mobile Card UX
- **CTA Redesign** (3 iterații):
  1. Dark gradient + Canvas ribbon animation (18 ribbons, brand colors) → respins ("groaznic")
  2. Rollback greșit la original → utilizatoarea voia doar eliminarea canvas-ului
  3. Dark gradient + eyebrow badge + gradient button cu glow + trust indicators (fără canvas) → aprobat
  4. Buton secundar "Cum funcționează?" eliminat (link `/#process` stricat, un singur CTA e mai clar)
- **Section Spacing** — fix-uri bazate pe screenshot-ul utilizatoarei:
  - Services: `py-16 md:py-24` → `pt-10 pb-16 md:pt-14 md:pb-24` (reducere gap deasupra)
  - UseCases: `py-16 md:py-24` → `pt-10 pb-16 md:pt-14 md:pb-24` (reducere gap dedesubt Services)
  - IntegrationHub: `py-12` → `py-16` pe mobile (normalizare la standard)
  - CTA: `py-20 md:py-28 lg:py-36` → `py-16 md:py-24 lg:py-28` (reducere disproporție)
- **Mobile Card Centering** — toate cardurile centrate (`snap-center` + `w-[85vw]`):
  - ProcessAutomationPage: 2 secțiuni (Process Types, Benefits)
  - ConversationalAgentsPage: 3 secțiuni (Capabilities, Industries, Benefits)
  - AiIntegrationsPage: 3 secțiuni (Systems, Capabilities, Benefits)
  - AboutPage: 2 secțiuni (Approach, WhyUs)
  - BenefitsStrip + IntegrationHub: `snap-start` → `snap-center`
- **Dynamic Scroll Arrows** — indicatori de direcție bazați pe scroll position:
  - Pattern: `data-scroll-hint` (pe div indicator) + `data-scroll-container` (pe scroll container)
  - `data-arrow-left`: opacity 0 la start, 1 + animate-pulse altfel
  - `data-arrow-right`: opacity 1 + animate-pulse la start, 0 la end
  - JavaScript: `scrollLeft`, `scrollWidth`, `clientWidth` pe event `scroll` (passive: true)
  - Aplicat pe: Services, UseCases (homepage), ProcessAutomation, ConversationalAgents (2x), AiIntegrations (2x)
- **Commits**: `18e7af6` (spacing + CTA cleanup), `d4ac6c9` (card centering), `a505d09` (dynamic arrows)

### Sesiune Februarie 2026 - AI Integrations 6th Card + Language Switcher Scroll
- **6th Capability Card** pe AiIntegrationsPage — grid incomplet (3+2) completat la 3+3:
  - **RO**: "Notificări și alerte inteligente" — reminder-e programare, confirmări plată, alerte stoc, actualizări status prin SMS/email/WhatsApp
  - **EN**: "Smart notifications and alerts"
  - Icon: `notifications` (bell icon, Heroicons)
  - Fișiere: `ro.json`, `en.json` (item adăugat în `serviceIntegrations.capabilities.items`), `AiIntegrationsPage.astro` (icon rendering)
- **Language Switcher Scroll Preservation** — la schimbarea limbii utilizatorul rămâne în aceeași poziție:
  - **Problema**: Click pe RO/EN ducea la începutul paginii (navigare completă `<a href>`)
  - **Soluția**: `sessionStorage` cu scroll position ca procent (nu pixeli — paginile traduse pot avea înălțimi diferite)
  - **Flow**: click → salvează `window.scrollY / maxScroll` → navigare → `requestAnimationFrame` → `scrollTo({ behavior: 'instant' })` → ștergere din storage
  - CSS class `lang-switch-link` pe link-urile de limbă pentru targeting JS
  - Events: `DOMContentLoaded` + `astro:page-load` (SPA compatibility)
- **Commits**: `e5d2b61` (6th capability), `9051fc0` (scroll preservation), `060f48a` (instant scroll)

### ⚠️ Lecții din Sesiunea Logo Redesign
1. **Rollback parțial vs total**: Când utilizatorul zice "rollback", clarifică CE anume. Nu presupune.
2. **Browser cache**: Favicon-urile și imaginile sunt puternic cached. Recomandă Ctrl+Shift+R.
3. **Vercel preview URLs**: Fiecare push creează un URL unic. URL-uri vechi NU se actualizează automat — trebuie accesat cel mai recent din dashboard.
4. **Sharp pentru imagini**: Astro include Sharp ca dependență. Poate fi folosit cu `node -e "require('sharp')..."` pentru crop, resize, background removal.
5. **PNG transparent background**: Tehnica pixel-by-pixel — verifică dacă RGB > threshold și channels similare (near-gray), apoi setează alpha=0.

---

## 🌐 HREFLANG & MULTILINGV — STRATEGIE SEO

> **Pentru AI**: Această secțiune conține decizii strategice despre versiunea multilingvă a site-ului.

### Decizia: Păstrăm versiunea EN

**Motivație**: Versiunea EN nu afectează negativ SEO-ul. Google tratează limbi separate corect dacă hreflang e implementat. Crawl budget nu e o problemă pentru site-uri mici (~34 pagini).

### Prioritizare

| Aspect | Decizie |
|--------|---------|
| **Limba principală** | Română (x-default → RO) |
| **Conținut nou** | Întotdeauna RO first, apoi EN |
| **Keyword targeting** | Doar RO activ, EN pasiv (traducere fără SEO targeting) |
| **Blog viitor** | Începe doar în RO |
| **x-default** | Pointează la versiunea RO (nu EN) |

### Implementare Hreflang (Automată)

Hreflang se generează automat în `BaseLayout.astro` pentru TOATE paginile:
- `hreflang="ro"` → URL pagina RO
- `hreflang="en"` → URL pagina EN
- `hreflang="x-default"` → URL pagina RO (fallback)

**Condiție CRITICĂ**: Fiecare pagină nouă **TREBUIE** să aibă path mappings în `i18n/index.ts`, altfel hreflang generează URL-uri greșite!

### De ce contează

1. **Fără hreflang**: Google poate vedea `/ro/despre/` și `/en/about/` ca pagini separate care concurează → dilution of authority
2. **Cu hreflang**: Google consolidează semnalele SEO și servește limba corectă utilizatorului
3. **31% din români vorbesc engleză** → 69% din audiență nu va folosi niciodată versiunea EN
4. **Expats & multinationale**: Versiunea EN oferă credibilitate și acces pentru non-români

---

## 📧 EMAIL SYSTEM - RESEND HTTP API (DETALII TEHNICE)

> **Pentru AI**: Această secțiune conține specificațiile complete pentru sistemul de email. Citește înainte de orice modificare la EmailService.

### De Ce NU SMTP

Railway (și multe cloud platforms) **blochează porturile SMTP outbound** (25, 465, 587) pentru a preveni spam-ul. Asta afectează ORICE provider SMTP (cPanel, Gmail SMTP, Resend SMTP, etc.).

**Soluția**: Folosim Resend HTTP API pe port 443 (HTTPS) care e mereu disponibil.

### Resend Configuration

| Aspect | Valoare |
|--------|---------|
| **Provider** | Resend.com (cont GitHub OAuth) |
| **Plan** | Free (3000 emails/lună) |
| **API Endpoint** | `https://api.resend.com/emails` |
| **Autentificare** | Bearer token (API key) |
| **Domeniu verificat** | `generativa.ro` (DKIM + SPF) |
| **Regiune** | Ireland (eu-west-1) |
| **From address** | `contact@generativa.ro` |

### DNS Records Adăugate (cPanel Zone Editor)

| Type | Name | Value |
|------|------|-------|
| TXT | `resend._domainkey.generativa.ro` | DKIM public key (`p=MIGfMA0GCSq...`) |
| MX | `send.generativa.ro` | `feedback-smtp.eu-west-1.amazonses.com` (priority 10) |
| TXT | `send.generativa.ro` | `v=spf1 include:amazonses.com ~all` |

### Railway Environment Variables (Email)

```
MAIL_HOST=smtp.resend.com        # Nu se mai folosește (SMTP blocat), dar păstrat
MAIL_PORT=465                    # Nu se mai folosește
MAIL_USERNAME=resend             # Nu se mai folosește
MAIL_PASSWORD=re_SSiJmdXw_...   # API key Resend — FOLOSIT de HTTP API
MAIL_PROTOCOL=smtps              # Nu se mai folosește
MAIL_SSL_ENABLE=true             # Nu se mai folosește
MAIL_STARTTLS_ENABLE=false       # Nu se mai folosește
EMAIL_FROM=contact@generativa.ro # Adresa expeditor
EMAIL_ADMIN=contact@generativa.ro # Adresa notificări admin
EMAIL_ENABLED=true               # Toggle global email
```

> **Notă**: Variabilele `MAIL_*` vechi rămân setate dar NU mai sunt folosite de EmailService (care acum folosește HTTP API). `MAIL_PASSWORD` e reutilizat ca Resend API key.

### Arhitectura Email Flow

```
User submit form → ContactController (HTTP thread)
    │
    ├─ Save to DB (sync, ~50ms) → Return 201 instant
    │
    └─ @Async → EmailService.sendAllEmails() (background thread)
         │
         ├─ POST https://api.resend.com/emails (admin notification)
         │   ├─ Success → continuă
         │   └─ Fail → log error, skip confirmation
         │
         ├─ POST https://api.resend.com/emails (user confirmation)
         │   └─ Doar dacă admin notification a reușit
         │
         └─ Update DB: processed=true/false, processed_at, notes
```

### Fișiere Modificate

| Fișier | Modificare |
|--------|-----------|
| `EmailService.java` | Rescris complet — Resend HTTP API în loc de JavaMailSender/SMTP |
| `ContactService.java` | Apelează `sendAllEmails()` (metodă unificată) |
| `AiAgentsApplication.java` | Adăugat `@EnableAsync` |
| `application.yml` | SMTP timeouts, env var parametrizare, mail health disabled |
| `application-prod.yml` | `ddl-auto: update` (era `validate`) |
| `nixpacks.toml` | Creat — start command pentru Railway |
| `Procfile` | Creat — alternativă start command |
| `ContactForm.astro` | Mesaj succes auto-hide după 5s |

### ⚠️ IMPORTANT — Railway Constraints

1. **SMTP blocat** — NU încerca să folosești SMTP de pe Railway, indiferent de provider
2. **Private networking** — `*.railway.internal` hostnames NU funcționează cu `railway up` (CLI deploy), doar cu GitHub auto-deploy
3. **DATABASE_URL** — trebuie prefix `jdbc:postgresql://` și URL public (`metro.proxy.rlwy.net`) pentru CLI deploys
4. **Maven wrapper** — NU adăuga `mvnw` — Nixpacks folosește `mise` care gestionează Java/Maven direct
5. **Build time** — ~2-3 min (Maven build + app start). Prima cerere după deploy poate fi mai lentă (JVM warmup)

### Railway All Variables (February 2026)

```
SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=jdbc:postgresql://metro.proxy.rlwy.net:32252/railway
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=RHiVbAXqsXtuIoqvsEMXPopcYjcvSARB
MAIL_HOST=smtp.resend.com
MAIL_PORT=465
MAIL_USERNAME=resend
MAIL_PASSWORD=re_SSiJmdXw_MUuf9eTTqgmWjoUDJPDmwFzo
MAIL_PROTOCOL=smtps
MAIL_SSL_ENABLE=true
MAIL_STARTTLS_ENABLE=false
EMAIL_FROM=contact@generativa.ro
EMAIL_ADMIN=contact@generativa.ro
EMAIL_ENABLED=true
```

---

## 📝 CONTACT FORM - DETALII TEHNICE

> **Pentru AI**: Această secțiune conține specificațiile formularului de contact. Citește înainte de orice modificare la ContactForm.astro.

### Câmpuri Formular

| Câmp | Tip | Required | Validare |
|------|-----|----------|----------|
| **Nume** | `text` | ✅ | Min 2 caractere, max 100 |
| **Email** | `email` | ✅ | Regex comprehensive |
| **Companie** | `text` | ✅ | Min 2 caractere, max 100 |
| **Industrie** | `select` | ✅ | Must select a non-empty option |
| **Interes** | `select` | ✅ | Must select a non-empty option |
| **Telefon** | `tel` | ❌ | Dacă completat: doar caractere valide + 7-15 cifre (E.164) |
| **Mesaj** | `textarea` | ✅ | Min 10 caractere |

### Opțiuni Industry (8)

| Key | RO | EN |
|-----|----|----|
| `dental` | Clinică dentară | Dental clinic |
| `medical` | Cabinet medical | Medical practice |
| `beauty` | Salon beauty / SPA | Beauty salon / SPA |
| `auto` | Service auto | Auto service |
| `horeca` | HoReCa (restaurant, hotel) | HoReCa (restaurant, hotel) |
| `retail` | Retail / E-commerce | Retail / E-commerce |
| `network` | Rețea multi-locații | Multi-location network |
| `other` | Altă industrie | Other industry |

### Opțiuni Interest (4)

| Key | RO | EN |
|-----|----|----|
| `automation` | Automatizare procese | Process automation |
| `conversational` | Agenți conversaționali (voice/chat) | Conversational agents (voice/chat) |
| `integrations` | Integrări AI cu sisteme existente | AI integrations with existing systems |
| `unsure` | Nu sunt sigur(ă) încă | Not sure yet |

### Validare — Abordare Tehnică

- `novalidate` pe `<form>` — dezactivează validarea nativă browser
- Validare custom în JS via `validateField(fieldName, value)` → returnează mesaj eroare sau `''`
- `define:vars={{ validationMessages: v }}` — Astro trece mesajele traduse (server → client)
- Erori afișate inline sub fiecare câmp (`<p class="field-error">`)
- Stil error: `border-color: #dc2626` + text roșu sub input
- Events: `input` pentru text fields, `change` pentru selects, `blur` pentru validare la pierdere focus

### Backend Compatibility — Industry/Interest Prepend

Backend-ul DTO (`ContactRequestDTO.java`) NU are câmpuri `industry`/`interest`. În loc de a modifica backend-ul (care ar necesita deploy), dropdown-urile se adaugă la începutul mesajului:

```
[Industrie: Clinică dentară]
[Interes: Automatizare procese]

Mesajul original al utilizatorului...
```

**Dacă în viitor** se adaugă câmpuri `industry` + `interest` la backend:
1. Adaugă în `ContactRequestDTO.java`
2. Adaugă în `ContactRequest.java` (entity)
3. Adaugă coloane în DB (auto via `ddl-auto: update`)
4. Trimite separat în `requestBody` din ContactForm.astro
5. Elimină prepend-ul la mesaj

### Traduceri

Mesajele de validare sunt în `contact.form.validation` din `ro.json`/`en.json`:
- `nameRequired`, `nameMin`, `emailRequired`, `emailInvalid`
- `companyRequired`, `companyMin`, `industryRequired`, `interestRequired`
- `phoneInvalid`, `messageRequired`, `messageMin`

---

*Ultima actualizare: Februarie 2026*
*Pentru detalii complete despre strategie, vezi `docs/STRATEGY.md`*

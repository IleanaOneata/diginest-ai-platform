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

### În lucru:
- [ ] Rafinare conținut și copy pentru toate secțiunile
- [ ] Test complet pe staging
- [ ] Mobile responsive fine-tuning

### Următorii pași:
1. [ ] Push și verificare pe staging URL
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
6. Benefits            → Rezultate concrete (existent)
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
- **Design**: Litera "G" cu gradient + noduri orbitale animate
- **Variante**: `default` (pe light), `white` (pe dark)

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

### Flow Homepage (RO & EN)

```
frontend/src/pages/ro/index.astro
frontend/src/pages/en/index.astro

Secțiuni în ordine:
1. <HeroInteractive />   - Demo chat + headline + CTA
2. <BenefitsStrip />     - 6 beneficii vizuale
3. <Services />          - Ce oferim (3 servicii)
4. <UseCases />          - 6 industrii cu problemă→soluție
5. <IntegrationHub />    - Hub central + 8 conexiuni
6. <Benefits />          - Rezultate cu numere
7. <Process />           - 4 pași cum funcționăm
8. <FAQ />               - Întrebări frecvente
9. <CTA />               - Contact final
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
│   │   ├── favicon.svg
│   │   └── images/
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

---

## 📚 DOCUMENTE CONEXE

| Document | Conține |
|----------|---------|
| `docs/STRATEGY.md` | Analiză competitivă detaliată, strategie diferențiere, design system Stripe |
| `docs/branding/BRANDING-NOTES.md` | Detalii logo, culori, tipografie |
| `docs/DEPLOYMENT.md` | Ghid deployment Vercel + Railway |
| `docs/MAINTENANCE.md` | Ghid mentenanță și actualizări |

---

## 🔄 ISTORIC SESIUNI

### Sesiune Februarie 2026 - Redesign Major
- Analiză competitivă (Agentic.ro, Inflate.agency)
- Strategie "Demo-First + Storytelling"
- Implementare HeroInteractive cu ChatSimulator
- Creare BenefitsStrip, UseCases, IntegrationHub
- Redesign IntegrationHub stil Stripe (gradient dark, glassmorphism, linii animate)

---

*Ultima actualizare: Februarie 2026*
*Pentru detalii complete despre strategie, vezi `docs/STRATEGY.md`*

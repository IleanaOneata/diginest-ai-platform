# GENERATIVA - Branding Notes

> **Pentru AI in sesiuni noi**: Acest document contine TOATE deciziile de branding, design system si filozofia din spatele lor. Citeste-l complet inainte de orice task vizual.

## Status: IMPLEMENTAT
**Ultima actualizare**: 11 Februarie 2026 — Color Palette Redesign (Option D: Deep Slate + Warm Amber)

---

## 0. Quick Reference (pentru AI)

| Element | Valoare |
|---------|---------|
| **Nume** | GENERATIVA |
| **Tagline RO** | "Agenti AI pentru afacerea ta" |
| **Tagline EN** | "AI Agents for your business" |
| **Primary color** | Deep Slate `#1E293B` (autoritate, incredere) |
| **Accent/CTA color** | Warm Amber `#F59E0B` (conversie, actiune) |
| **Heading color** | `#263244` (neutral-750) — nu negru pur |
| **Dark sections bg** | `radial-gradient(ellipse at top, #1E293B 0%, #0F172A 50%, #020617 100%)` |
| **UI Font** | **Inter** (Google Font) — weights 400, 500, 600, 700 |
| **Logo Font** | **Prompt** (Google Font) — doar pe logo SVG inline |
| **Logo** | Inline SVG wordmark — `frontend/src/components/common/Logo.astro` |
| **Favicon** | Toggle switch (amber pe deep slate) — `public/favicon.svg` |
| **CTA buttons** | Flat amber `#F59E0B`, hover `#D97706` — NU gradient |
| **Card radius** | 16px |
| **Button/Input radius** | 12px |
| **Badge radius** | 999px (full round) |

---

## 1. BRAND

### Nume: GENERATIVA
- **Domeniu tinta**: generativa.ro (de achizitionat)
- **De ce**: Suna profesional, comunica AI generativa, memorabil, 10 litere

### Tagline
- **RO**: "Agenti AI pentru afacerea ta"
- **EN**: "AI Agents for your business"

---

## 2. PALETA DE CULORI — OPTION D (Deep Slate + Warm Amber)

### Filozofia din spatele culorilor

Paleta a fost aleasa pe baza a 4 principii stiintifice validate in B2B:

#### 2.1 De ce Deep Slate (#1E293B) ca baza?
- **Psihologie**: Navy/slate este culoarea nr.1 in B2B tech pentru ca comunica **stabilitate, competenta, incredere**
- **Studii**: Institute for Color Research — 62-90% din prima impresie se bazeaza pe culoare
- **Pattern validat**: Stripe, Linear, Vercel, Notion — toate folosesc dark neutrals ca fundament
- **Target audience**: Decision-makeri B2B (CEO, office manager) care iau decizii cu banii firmei au nevoie sa se simta **in siguranta**
- **Vs competitie**: Agentic.ro foloseste dark neon agresiv care poate intimida. Noi folosim slate care e **serios dar accesibil**

#### 2.2 De ce Warm Amber (#F59E0B) ca accent de conversie?
- **HubSpot study** (50,000+ landing pages): butoanele orange/amber au **32-40% mai multe click-uri** decat cele albastre sau verzi
- **Efectul Von Restorff**: Creierul retine automat elementul care iese din context. Amber pe fundal rece = imposibil de ignorat
- **Amazon, Chewy, Etsy** — toate folosesc orange pe butoanele de actiune
- **Caldura emotionala**: Amber comunica energie, urgenta pozitiva, accesibilitate — exact ce vrem pe CTA-uri pentru un public cu nivel mediu de tech savviness

#### 2.3 Regula 60-30-10
- **60% neutral** — fundaluri albe, spatii goale, text → creeaza respiratie
- **30% slate** — sectiuni dark, headings, structura → creeaza autoritate
- **10% amber** — DOAR pe CTA-uri, accente, stat numbers → creeaza urgenta pozitiva

Cand ai o **singura culoare de accent** (amber), ochiul stie instant unde sa se uite. Cu 2-3 culori vibrante, atentia se fragmenteaza.

#### 2.4 De ce FLAT, nu gradient pe CTA-uri?
- **Nielsen Norman Group + Baymard Institute** (cercetari UX 2024-2025): butoanele cu o singura culoare solida au rata de click mai mare decat cele cu gradient
- Gradientul e decorativ; solidul comunica clar "acesta e butonul"
- Un singur CTA dominant pe pagina (amber) > multiple butoane colorate

#### 2.5 Ce comunica paleta vizitatorului
Cand un owner de clinica dentara sau un manager HoReCa intra pe site:
- **Slate-ul** zice: "Suntem seriosi, stabili, nu o firma de ieri"
- **Amber-ul** zice: "Actioneaza acum — e usor, e cald, nu e intimidant"
- **Spatiul alb** zice: "Nu te coplesim, suntem organizati"

### Istoric palete (de ce NU celelalte)

| Paleta | Culori | De ce respinsa |
|--------|--------|----------------|
| Initiala (v1) | Cyan #16B6C9 + Purple #7C3AED (3-stop gradient) | Prea "tech-bro", fragmenta atentia, CTA-uri neclare |
| Option A | Teal + Indigo | Respinsa de client |
| Option B | Navy + Teal | Respinsa de client |
| Option C | Teal + Navy | Respinsa de client |
| **Option D** | **Deep Slate #1E293B + Warm Amber #F59E0B** | **APROBATA — research-backed, B2B-optimized** |

### Culorile principale

| Culoare | Hex | Token Tailwind | Utilizare |
|---------|-----|---------------|-----------|
| Deep Slate | `#1E293B` | `primary-800` | Sectiuni dark, structura, headings pe dark |
| Slate dark | `#0F172A` | `primary-900` | Dark backgrounds, footer |
| Slate darkest | `#020617` | `primary-950` | Gradient dark endpoint |
| **Amber** | **`#F59E0B`** | **`accent-500`** | **CTA-uri, accente, stat values** |
| Amber hover | `#D97706` | `accent-600` | Hover pe butoane, link-uri |
| Amber light | `#FBBF24` | `accent-400` | Gradient start pe voice widget |
| Amber bg | `#FFFBEB` | `accent-50` | Background subtle pe badges |
| Heading text | `#263244` | `neutral-750` | Toate titlurile pe light bg |
| Body text | `#475569` | `neutral-600` | Paragrafe, text secundar |
| Light bg | `#F8FAFC` | `neutral-50` | Fundal pagina |

### Implementare Tailwind

```javascript
// tailwind.config.mjs
colors: {
  // Primary — Deep Slate (authority, trust, sophistication)
  primary: {
    50: '#F8FAFC',
    100: '#F1F5F9',
    200: '#E2E8F0',
    300: '#CBD5E1',
    400: '#94A3B8',
    500: '#64748B',
    600: '#475569',
    700: '#334155',
    800: '#1E293B', // Brand deep slate
    900: '#0F172A',
    950: '#020617',
  },
  // Accent — Warm Amber (energy, conversion, action)
  accent: {
    50: '#FFFBEB',
    100: '#FEF3C7',
    200: '#FDE68A',
    300: '#FCD34D',
    400: '#FBBF24',
    500: '#F59E0B', // Brand amber — CTA/accent
    600: '#D97706', // Hover state
    700: '#B45309',
    800: '#92400E',
    900: '#78350F',
    950: '#451A03',
  },
  neutral: {
    50: '#F8FAFC',
    100: '#F1F5F9',
    200: '#E2E8F0',
    300: '#CBD5E1',
    400: '#94A3B8',
    500: '#64748B',
    600: '#475569',
    700: '#334155',
    750: '#263244',  // Custom shade pentru headings
    800: '#1E293B',
    900: '#0F172A',
    950: '#020617',
  },
  brand: {
    slate: '#1E293B',
    amber: '#F59E0B',
    dark: '#0F172A',
    light: '#F8FAFC',
  },
}
```

### ATENTIE: primary vs accent pe dark backgrounds

Cu `primary` = slate, clasele Tailwind `text-primary-400` pe sectiuni dark devin **gri pe negru = invizibil**. Pe sectiuni dark, foloseste **`accent-*`** (amber) pentru iconite, badge-uri, CTA-uri, si orice element care trebuie sa fie vizibil.

**Regula**: Pe dark backgrounds → **accent-*** (amber). Pe light backgrounds → **primary-*** (slate) sau **accent-*** pentru CTA.

### Gradiente

```css
/* Gradient pentru sectiuni dark */
gradient-brand: linear-gradient(135deg, #1E293B 0%, #334155 50%, #0F172A 100%);
gradient-dark: radial-gradient(ellipse at top, #1E293B 0%, #0F172A 50%, #020617 100%);

/* Gradient pentru Hero (light, cu hint de amber cald) */
gradient-hero: linear-gradient(to bottom right, #F8FAFC, #ffffff, #FFFBEB);

/* Text gradient (rar folosit) */
text-gradient: linear-gradient(135deg, #1E293B 0%, #F59E0B 100%);
```

---

## 3. LOGO - IMPLEMENTARE FINALA

### Design Actual (v6)
- **Concept**: Inline SVG wordmark — "GENERATIVA" + "AI AUTOMATION" subtitle + toggle symbol (ON state)
- **Component**: `frontend/src/components/common/Logo.astro`
- **Font Logo**: **Prompt** (Google Font) — hardcodat in SVG `font-family`
- **Font UI**: **Inter** — fontul default `fontFamily.sans` din Tailwind

### Structura SVG
1. **"GENERATIVA"** — `<text>` Prompt Bold (700), font-size 48, letter-spacing 0.04em
2. **"AI AUTOMATION"** — `<text>` Prompt Medium (500), font-size 16.8, letter-spacing 0.2em
3. **Toggle symbol** — `<rect>` rounded (rx=18) + `<circle>` knob la dreapta (ON state)

### viewBox
```
viewBox="-2 -2 400 72"
```
**NU MODIFICA viewBox** — iteratii anterioare au demonstrat ca ajustarea y-offset taie textul sau toggle-ul.

### Variante disponibile

| Prop | Optiuni | Descriere |
|------|---------|-----------|
| `size` | sm, md, lg, xl | Dimensiune logo |
| `showText` | true/false | Afisare text (mereu true in practica) |
| `variant` | default, white, dark | Pentru light/dark backgrounds |

### Color per Variant

| Variant | Wordmark | Subtitle | Toggle |
|---------|----------|----------|--------|
| `default` | `#0B0B0B` | `#666666` | `#0B0B0B` |
| `white` | `white` | `#8A8A8A` | `white` |
| `dark` | `#0B0B0B` | `#666666` | `#0B0B0B` |

### Favicon
- **Design**: Toggle switch (din logo) pe fundal Deep Slate
- **SVG**: `public/favicon.svg` — rect rotunjit (#1E293B bg) + toggle amber (#F59E0B)
- **PNG**: Generate automat cu Sharp din SVG
  - `favicon-32.png` (32x32)
  - `favicon-16.png` (16x16)
  - `apple-touch-icon.png` (180x180)

### Istoric Logo

| Versiune | Descriere | Status |
|----------|-----------|--------|
| v1 | Retea neurala SVG, purple | Respins |
| v2 | Hexagon geometric | "Prea colturos" |
| v3 | G din noduri orbitale | G arata ca C |
| v4 | G solid + noduri orbitale animate | Folosit o perioada |
| v5 | 3D G letter PNG (AI-generated) | Folosit o perioada |
| **v6** | **SVG wordmark + Prompt font + toggle** | **ACTUAL** |

---

## 4. TYPOGRAPHY

### Sistem dual: Inter (UI) + Prompt (Logo)

**De ce Inter pentru UI?**
- Inter e conceput specific pentru ecrane si interfete
- Compact, lizibil la orice dimensiune, nu "alungeste" textul
- Standard in SaaS B2B (Vercel, Linear, Notion il folosesc)

**De ce Prompt pentru Logo?**
- Geometrie clean, arata excelent in ALL CAPS
- Personalitate distincta — diferentiaza brand-ul de UI text

### Configurare

```javascript
// tailwind.config.mjs
fontFamily: {
  sans: ['Inter', 'system-ui', '-apple-system', 'sans-serif'],  // Tot UI-ul
  brand: ['Prompt', 'system-ui', 'sans-serif'],                  // Doar logo
  mono: ['JetBrains Mono', 'monospace'],
},
```

```html
<!-- BaseLayout.astro — Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&family=Prompt:wght@600;700&display=swap" rel="stylesheet" />
```

### Heading Styles (global.css)

```css
h1, h2, h3, h4, h5, h6 {
  color: #263244;  /* neutral-750 */
}

h1 { @apply text-display-lg md:text-display font-bold; letter-spacing: -0.01em; }
h2 { @apply text-heading-lg font-bold; }
h3 { @apply text-heading font-semibold; }
h4 { @apply text-heading-sm font-semibold; }
```

### Custom Font Sizes (neschimbate)

| Token | Size | Utilizare |
|-------|------|-----------|
| `display-lg` | 3.75rem (60px) | H1 mobile |
| `display` | 3rem (48px) | H1 desktop |
| `heading-lg` | 2.25rem (36px) | H2 |
| `heading` | 1.875rem (30px) | H3 |
| `heading-sm` | 1.5rem (24px) | H4 |
| `body` | 1rem (16px) | Paragrafe |
| `body-sm` | 0.875rem (14px) | Text secundar |

---

## 5. COMPONENTE UI

### Button System

Butoanele CTA (primary, gradient) au **background amber FLAT inline** — nu se bazeaza pe clase Tailwind bg-gradient-brand (care e slate pe slate).

```javascript
// Button.astro — logica
const isCtaVariant = variant === 'primary' || variant === 'gradient';
const ctaStyle = isCtaVariant
  ? 'border-radius: 12px; background: #F59E0B;'
  : 'border-radius: 12px;';
```

| Variant | Background | Text | Hover |
|---------|-----------|------|-------|
| `primary` | Flat `#F59E0B` (amber) | White | `#D97706` |
| `gradient` | Flat `#F59E0B` (amber) | White | `#D97706` |
| `secondary` | White | `neutral-900` | `neutral-50` bg |
| `outline` | Transparent | `accent-600` | `accent-50` bg |
| `ghost` | Transparent | `neutral-600` | `neutral-100` bg |

### Card Style

```css
.card {
  background: white;
  border: 1px solid #E2E8F0; /* neutral-200 */
  border-radius: 16px;
  padding: 1.5rem;
}
.card:hover {
  box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.08); /* shadow-soft */
  border-color: #CBD5E1; /* neutral-300 */
}
```

### Language Switcher
- **Active state**: `bg-primary-800` (solid deep slate pill)
- **Inactive**: `text-neutral-500 hover:text-neutral-700`
- **Design**: Toggle pill compact (RO | EN), fara emoji flags

### ScrollToTop
- **Background**: Flat `#F59E0B` (amber), hover `#D97706`
- **Shadow**: amber rgba values

---

## 6. SECTIUNI DARK — Reguli vizuale

### Background
```css
background: radial-gradient(ellipse at top, #1E293B 0%, #0F172A 50%, #020617 100%);
```

### Regula CRITICA: culori pe dark
- **Titluri**: `text-white` EXPLICIT (nu te baza pe mostenire)
- **Paragrafe**: `text-slate-300` sau `text-slate-400`
- **Iconite/accente**: `text-accent-400` (amber) — NU `text-primary-400` (gri invizibil!)
- **Badge-uri**: `bg-accent-500/10 text-accent-300 border-accent-500/20`
- **CTA pe dark**: `bg-accent-500 hover:bg-accent-600`

### Hub central (IntegrationHub)
```css
background: linear-gradient(to bottom right, #F59E0B, #B45309);
/* bg-gradient-to-br from-accent-500 to-accent-700 */
```

---

## 7. EMAIL TEMPLATES — Consistenta brand

### Culori in email HTML (EmailService.java)
- **Logo "G"**: `color:#D97706` (amber-600, vizibil pe alb)
- **Link-uri**: `color:#D97706` (amber-600)
- **Numere pasi**: `color:#D97706` (amber-600)
- **Steps box bg**: `background-color:#fffbeb` (amber-50) + `border:1px solid #fde68a` (amber-200)
- **Font**: `'Helvetica Neue',Helvetica,Arial,sans-serif` (email-safe, NU Google Fonts)

---

## 8. POZITIONARE PE PIATA

### Cum ne diferentiem vizual de competitie

| Aspect | Agentic.ro (competitie) | GENERATIVA |
|--------|-------------------------|------------|
| **Paleta** | Dark neon violet/cyan — agresiv, "gaming" | Deep Slate + Amber — profesionist, cald |
| **CTA** | Butoane gradient multi-color | Flat amber — un singur focal point |
| **Ton vizual** | "Suntem high-tech si cool" | "Suntem seriosi DAR accesibili" |
| **Target** | Developers, tech-savvy | SME owners (medic, stilist, restaurateur) |
| **First impression** | "Impresionant dar complicat" | "Professional si usor de inteles" |

### Mesajul psihologic al design-ului

**Pentru decision-makerul B2B** (Maria, owner clinica dentara, 40 ani):
1. **Deschide site-ul** → vede spatiu alb, titluri clare, un singur buton amber = "Astia stiu ce fac, nu ma coplesesc"
2. **Vede voice widget** → cerc amber mare cu animatie subtila = "Pot incerca fara sa ma angajez"
3. **Scrolleaza** → sectiuni dark cu amber accents = "Arata serios, ca la o firma mare"
4. **CTA final** → buton amber clar = "E simplu sa ii contactez"

**Keyword**: Incredere prin simplitate, nu prin spectacol.

---

## 9. FISIERE BRAND

### In repository
```
docs/branding/
  BRANDING-NOTES.md              # Acest fisier

frontend/
  src/components/common/
    Logo.astro                   # Logo SVG inline (font Prompt)
  public/
    favicon.svg                  # Toggle switch (amber pe deep slate)
    favicon-32.png               # PNG 32x32
    favicon-16.png               # PNG 16x16
    apple-touch-icon.png         # iOS icon 180x180
    images/
      generativa-logo-black.svg  # SVG export (dark variant)
      generativa-logo-white.svg  # SVG export (white variant)
  tailwind.config.mjs            # Design tokens brand
  src/styles/global.css          # Typography defaults + utility classes
```

### De creat (TODO)
- [ ] OG Image pentru social sharing (1200x630) — cu noul branding amber/slate

---

*Document actualizat: 11 Februarie 2026 — Option D: Deep Slate + Warm Amber (research-backed B2B palette)*

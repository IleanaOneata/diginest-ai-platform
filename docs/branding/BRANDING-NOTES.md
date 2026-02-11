# GENERATIVA - Branding Notes

> **Pentru AI în sesiuni noi**: Acest document conține toate deciziile de branding și design system. Citește-l pentru context vizual.

## Status: ✅ IMPLEMENTAT
**Ultima actualizare**: 11 Februarie 2026

---

## 0. Quick Reference (pentru AI)

| Element | Valoare |
|---------|---------|
| **Nume** | GENERATIVA |
| **Tagline RO** | "Agenți AI pentru afacerea ta" |
| **Tagline EN** | "AI Agents for your business" |
| **Brand Gradient** | `linear-gradient(90deg, #16B6C9 0%, #4F7CF3 50%, #7C3AED 100%)` |
| **Heading color** | `#263244` (neutral-750) — nu negru pur |
| **Dark sections** | `radial-gradient(ellipse at top, #111827 0%, #0B0F1A 50%, #1E1B4B 100%)` |
| **Font** | **Prompt** (Google Font) — weights 400, 500, 600, 700 |
| **Logo** | Inline SVG wordmark — `frontend/src/components/common/Logo.astro` |
| **Card radius** | 16px |
| **Button/Input radius** | 12px |
| **Badge radius** | 999px (full round) |

---

## 1. BRAND

### Nume: GENERATIVA
- **Domeniu țintă**: generativa.ro (de achiziționat)
- **De ce**: Sună profesional, comunică AI generativă, memorabil, 10 litere

### Tagline
- **RO**: "Agenți AI pentru afacerea ta"
- **EN**: "AI Agents for your business"

---

## 2. PALETĂ DE CULORI

### Brand Gradient (3-stop — ACTUALIZAT Februarie 2026)

```css
/* Gradient principal — folosit peste tot */
background: linear-gradient(90deg, #16B6C9 0%, #4F7CF3 50%, #7C3AED 100%);
/* Cyan → Blue → Violet */
```

### Culorile principale

| Culoare | Hex | Token Tailwind | Utilizare |
|---------|-----|---------------|-----------|
| Cyan | `#16B6C9` | `primary-500` | Start gradient, primary actions |
| Cyan light | `#22D3EE` | `primary-400` | Hover states, accents |
| Blue | `#4F7CF3` | — | Mijloc gradient (doar inline) |
| Violet | `#7C3AED` | `accent-600` | End gradient |
| Violet light | `#8B5CF6` | `accent-500` | Accent secundar |
| Heading text | `#263244` | `neutral-750` | Toate titlurile pe light bg |
| Body text | `#475569` | `neutral-600` | Paragrafe, text secundar |
| Dark bg | `#0B0F1A` | `neutral-950` | Centre secțiuni dark |
| Light bg | `#F7F8FA` | `neutral-50` | Fundal pagină, secțiuni alternate |

### Implementare Tailwind

```javascript
// tailwind.config.mjs — extracte relevante
colors: {
  primary: {
    50: '#ECFEFF',
    100: '#CFFAFE',
    200: '#A5F3FC',
    300: '#67E8F9',
    400: '#22D3EE',
    500: '#16B6C9',    // Start gradient brand
    600: '#0891B2',
    700: '#0E7490',
    800: '#155E75',
    900: '#164E63',
  },
  accent: {
    50: '#FAF5FF',
    100: '#F3E8FF',
    200: '#E9D5FF',
    300: '#D8B4FE',
    400: '#C084FC',
    500: '#8B5CF6',
    600: '#7C3AED',    // End gradient brand
    700: '#6D28D9',
    800: '#5B21B6',
    900: '#4C1D95',
  },
  neutral: {
    50: '#F7F8FA',
    100: '#F1F5F9',
    200: '#E2E8F0',
    300: '#CBD5E1',
    400: '#94A3B8',
    500: '#64748B',
    600: '#475569',
    700: '#334155',
    750: '#263244',    // ← Custom shade pentru headings
    800: '#1E293B',
    900: '#0F172A',
    950: '#0B0F1A',
  },
}
```

### ⚠️ ATENȚIE: neutral-750 și @apply

`text-neutral-750` funcționează în fișiere `.astro` (Tailwind JIT compilează la nevoie).
**NU funcționează** cu `@apply` în fișiere CSS/global.css (PostCSS nu recunoaște shades intermediare).

**Soluție în CSS**:
```css
/* ❌ GREȘIT — va da CssSyntaxError */
h1 { @apply text-neutral-750; }

/* ✅ CORECT — raw CSS value */
h1 { color: #263244; }
```

---

## 3. LOGO - IMPLEMENTARE FINALĂ (Februarie 2026)

### Design Actual
- **Concept**: Inline SVG wordmark — "GENERATIVA" + "AI AUTOMATION" subtitle + toggle symbol (ON state)
- **Component**: `frontend/src/components/common/Logo.astro`
- **Font**: Prompt — moștenit din fontul global încărcat în BaseLayout

### Structura SVG
1. **"GENERATIVA"** — `<text>` Prompt Bold (700), font-size 48, letter-spacing 0.04em
2. **"AI AUTOMATION"** — `<text>` Prompt Medium (500), font-size 16.8, letter-spacing 0.2em
3. **Toggle symbol** — `<rect>` rounded (rx=18) + `<circle>` knob la dreapta (ON state)

### viewBox
```
viewBox="-2 -2 400 72"
```
**⚠️ NU MODIFICA viewBox** — iterații anterioare au demonstrat că ajustarea y-offset taie textul sau toggle-ul.

### Variante disponibile

| Prop | Opțiuni | Descriere |
|------|---------|-----------|
| `size` | sm, md, lg, xl | Dimensiune logo |
| `showText` | true/false | Afișare text (mereu true în practică) |
| `variant` | default, white, dark | Pentru light/dark backgrounds |

### Size Configuration

| Size | Height | Min Width |
|------|--------|-----------|
| `sm` | `h-8` | 150px |
| `md` | `h-8 lg:h-9` | 160px |
| `lg` | `h-12` | 220px |
| `xl` | `h-16` | 300px |

### Color per Variant

| Variant | Wordmark | Subtitle | Toggle |
|---------|----------|----------|--------|
| `default` | `#0B0B0B` | `#666666` | `#0B0B0B` |
| `white` | `white` | `#8A8A8A` | `white` |
| `dark` | `#0B0B0B` | `#666666` | `#0B0B0B` |

### Utilizare
```astro
import Logo from '@components/common/Logo.astro';

<!-- Header (pe light) -->
<Logo size="md" showText={true} variant="default" />

<!-- Footer (pe dark) -->
<Logo size="md" showText={true} variant="white" />
```

### Fișiere Logo

| Fișier | Scop |
|--------|------|
| `Logo.astro` | Componenta principală (inline SVG) |
| `/images/generativa-logo-black.svg` | Export SVG pentru referință/fallback |
| `/images/generativa-logo-white.svg` | Export SVG white variant |
| `/images/generativa-g-512.png` | ⚠️ VECHI — logo PNG anterior, nu mai e folosit |
| `/images/generativa-g-200.png` | ⚠️ VECHI — poate fi șters |

### Istoric Logo

| Versiune | Descriere | Status |
|----------|-----------|--------|
| v1 | Rețea neurală SVG, purple | ❌ Respins |
| v2 | Hexagon geometric | ❌ "Prea colțuros" |
| v3 | G din noduri orbitale | ❌ G arăta ca C |
| v4 | G solid + noduri orbitale animate | ✅ Folosit o perioadă |
| v5 | 3D G letter PNG (AI-generated) | ✅ Folosit o perioadă |
| **v6** | **SVG wordmark + Prompt font + toggle** | ✅ **ACTUAL** |

---

## 4. TYPOGRAPHY

### Font Principal: Prompt (Google Font)

| Utilizare | Weight | Tailwind |
|-----------|--------|----------|
| Headings H1, H2 | 700 (Bold) | `font-bold` |
| Headings H3, H4 | 600 (SemiBold) | `font-semibold` |
| Body text | 400 (Regular) | `font-normal` |
| Labels, buttons | 500 (Medium) | `font-medium` |
| Logo wordmark | 700 (Bold) | — (inline SVG) |
| Logo subtitle | 500 (Medium) | — (inline SVG) |

### Heading Styles (global.css)

```css
h1, h2, h3, h4, h5, h6 {
  color: #263244;  /* neutral-750 */
}

h1 {
  @apply text-display-lg md:text-display font-bold;
  letter-spacing: -0.01em;
}

h2 {
  @apply text-heading-lg font-bold;
}

h3 {
  @apply text-heading font-semibold;
}

h4 {
  @apply text-heading-sm font-semibold;
}
```

### Custom Font Sizes

| Token | Size | Utilizare |
|-------|------|-----------|
| `display` | 3.5rem (56px) | H1 desktop |
| `display-lg` | 3rem (48px) | H1 mobile |
| `heading-lg` | 1.875rem (30px) | H2 |
| `heading` | 1.5rem (24px) | H3 |
| `heading-sm` | 1.25rem (20px) | H4 |
| `body` | 1rem (16px) | Paragrafe |
| `body-sm` | 0.875rem (14px) | Text secundar |
| `caption` | 0.75rem (12px) | Labels mici |

### Gradient Text

```css
.text-gradient {
  @apply bg-clip-text text-transparent;
  background-image: linear-gradient(90deg, #16B6C9 0%, #4F7CF3 50%, #7C3AED 100%);
}
```

---

## 5. COMPONENTE UI

### Button Variants

```css
.btn-primary {
  background: linear-gradient(90deg, #16B6C9 0%, #4F7CF3 50%, #7C3AED 100%);
  color: white;
  border-radius: 12px;
}

.btn-secondary {
  background: white;
  border: 1px solid neutral-200;
  color: neutral-900;
  border-radius: 12px;
}

.btn-outline {
  border: 1px solid primary-500;
  color: primary-500;
  border-radius: 12px;
}

.btn-ghost {
  color: neutral-600;
  background: transparent;
  border-radius: 12px;
}
```

### Card Style

```css
.card {
  background: white;
  border: 1px solid neutral-200;
  border-radius: 16px;
  padding: 1.5rem;
}

.card:hover {
  box-shadow: shadow-soft;
  border-color: neutral-300;
}
```

### Input Style

```css
.input {
  border: 1px solid neutral-200;
  border-radius: 12px;
  padding: 0.75rem 1rem;
}

.input:focus {
  border-color: primary-500;
  ring: 2px primary-500/20;
}
```

### Badge Style

```css
.badge {
  border-radius: 999px;
  padding: 0.25rem 0.75rem;
  font-size: 0.875rem;
  font-weight: 500;
}
```

---

## 6. FIȘIERE BRAND

### În repository
```
docs/branding/
├── BRANDING-NOTES.md              # Acest fișier
└── logo-concepts/
    └── generativa-logo-final-dark.png  # Referință PNG vechi

frontend/
├── src/components/common/
│   └── Logo.astro                 # ✅ Logo SVG inline (Prompt font)
├── public/
│   ├── favicon-32.png             # ✅ Favicon 32x32
│   ├── favicon-16.png             # ✅ Favicon 16x16
│   ├── apple-touch-icon.png       # ✅ iOS icon 180x180
│   └── images/
│       ├── generativa-logo-black.svg   # ✅ SVG export (dark)
│       ├── generativa-logo-white.svg   # ✅ SVG export (white)
│       ├── generativa-g-512.png        # ⚠️ Logo vechi PNG (nu mai e folosit)
│       └── generativa-g-200.png        # ⚠️ Logo vechi PNG mic
├── tailwind.config.mjs            # ✅ Design tokens brand
└── src/styles/global.css          # ✅ Typography defaults
```

### De creat (TODO)
- [ ] OG Image pentru social sharing (1200x630) — cu noul wordmark
- [ ] Favicon actualizat din noul SVG wordmark (opțional — cel curent e OK)

---

## 7. DESIGN PATTERNS

### Secțiuni Dark (stil Stripe)
Folosite în: `IntegrationHub.astro`, `ScaleWithConfidence.astro`, `CTA.astro`

```css
/* Background gradient dark */
background: radial-gradient(ellipse at top, #111827 0%, #0B0F1A 50%, #1E1B4B 100%);

/* Dot pattern overlay */
background-image: radial-gradient(rgba(255,255,255,0.1) 1px, transparent 1px);
background-size: 24px 24px;

/* Gradient orbs pentru depth */
background: rgba(22, 182, 201, 0.1); /* cyan */
filter: blur(60px);
```

### Cards pe Light Background
```css
.card {
  background: white;
  border: 1px solid theme('colors.neutral.200');
  border-radius: 16px;
  transition: all 200ms;
}

.card:hover {
  box-shadow: theme('boxShadow.soft');
  border-color: theme('colors.neutral.300');
}
```

### Principii de Design

1. **Restraint elegant** — spațiu > decorații
2. **3-stop gradient** — cyan→blue→violet creează profunzime vizuală
3. **Bold dar nu agresiv** — titluri `#263244`, nu negru pur
4. **Prompt font** — clean geometry, premium feel
5. **Consistent radius** — 12px (UI elements), 16px (cards), 999px (pills)
6. **Dark ≠ Black** — folosește `#0B0F1A` cu gradient, nu `#000`
7. **Animate subtil** — hover glow, counter animation, NU bounce agresiv

---

## 8. COMPONENTE VIZUALE

| Component | Locație | Stil |
|-----------|---------|------|
| VoiceWidget | `components/demo/` | Buton circular cu inele animate, gradient brand |
| ChatSimulator | `components/demo/` | Light, cu gradient header (nu mai e în Hero) |
| BenefitsStrip | `components/sections/` | Light background, icon cards |
| UseCases | `components/sections/` | Light cu gradient subtle |
| IntegrationHub | `components/sections/` | Dark stil Stripe |
| ScaleWithConfidence | `components/sections/` | Dark cu wave animation Canvas |
| CTA | `components/sections/` | Dark gradient cu glow button |

---

*Document actualizat: 11 Februarie 2026 — Refactoring complet: SVG wordmark, Prompt font, 3-stop gradient, design tokens*

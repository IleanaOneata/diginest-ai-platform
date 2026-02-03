# GENERATIVA - Branding Notes

> **Pentru AI în sesiuni noi**: Acest document conține toate deciziile de branding și design system. Citește-l pentru context vizual.

## Status: ✅ IMPLEMENTAT
**Ultima actualizare**: Februarie 2026

---

## 0. Quick Reference (pentru AI)

| Element | Valoare |
|---------|---------|
| **Nume** | GENERATIVA |
| **Tagline RO** | "Agenți AI pentru afacerea ta" |
| **Tagline EN** | "AI Agents for your business" |
| **Primary color** | `#22d3ee` (cyan) |
| **Accent color** | `#8b5cf6` (purple) |
| **Gradient** | `linear-gradient(135deg, #22d3ee 0%, #8b5cf6 100%)` |
| **Dark sections** | `linear-gradient(to-br, #0a1628, #0f172a, #1e1b4b)` - stil Stripe |
| **Font** | Inter (sans-serif) |
| **Logo** | `frontend/src/components/common/Logo.astro` |

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

### Culorile principale
| Culoare | Hex | Utilizare |
|---------|-----|-----------|
| Cyan vibrant | `#22d3ee` | Primary, start gradient |
| Indigo | `#6366f1` | Gradient mijloc |
| Purple electric | `#8b5cf6` | Accent, end gradient |
| Dark background | `#18181b` | Footer, dark sections |
| Light background | `#fafafa` | Main background |

### Gradient Brand
```css
background: linear-gradient(135deg, #22d3ee 0%, #6366f1 50%, #8b5cf6 100%);
```

### Implementare Tailwind
```javascript
// tailwind.config.mjs
colors: {
  primary: {
    400: '#22d3ee',  // Main cyan
    500: '#06b6d4',
    600: '#0891b2',  // Hover
  },
  accent: {
    500: '#a855f7',
    600: '#8b5cf6',  // Main purple
  },
  neutral: {
    50: '#fafafa',   // Light bg
    900: '#18181b',  // Dark bg
  }
}
```

---

## 3. LOGO - IMPLEMENTARE FINALĂ

### Design
- **Concept**: Litera "G" cu gradient + noduri orbitale animate
- **Component**: `frontend/src/components/common/Logo.astro`

### Structura SVG
1. **Cerc background** - subtil, opacity 8%
2. **Litera G** - stroke gradient, width 4, cu glow filter
3. **Bara orizontală** - clară, distinctivă
4. **4 noduri orbitale** - animate cu opacity pulsing
5. **Linii conexiune** - opacity 30%

### Variante disponibile
| Prop | Opțiuni | Descriere |
|------|---------|-----------|
| `size` | sm, md, lg, xl | Dimensiune logo |
| `showText` | true/false | Afișare "GENERATIVA" |
| `variant` | default, white | Pentru light/dark backgrounds |

### Utilizare
```astro
import Logo from '@components/common/Logo.astro';

<!-- Header (pe light) -->
<Logo size="md" showText={true} variant="default" />

<!-- Footer (pe dark) -->
<Logo size="md" showText={true} variant="white" />
```

---

## 4. TYPOGRAPHY

### Font Principal: Inter
- **Logo text**: ALL CAPS, bold, tracking-wide
- **Headings**: font-semibold
- **Body**: font-normal

### Gradient text
```css
.text-gradient {
  @apply bg-gradient-to-r from-primary-400 via-indigo-500 to-accent-600
         bg-clip-text text-transparent;
}
```

---

## 5. COMPONENTE UI

### Button variants
```javascript
variants: {
  primary: 'bg-primary-400 text-neutral-900 hover:bg-primary-500',
  gradient: 'bg-gradient-to-r from-primary-400 to-accent-600 text-white',
  outline: 'border-2 border-primary-400 text-primary-500',
  ghost: 'text-neutral-600 hover:bg-neutral-100'
}
```

### CTA recomandat
```astro
<Button variant="gradient" size="lg">
  Programează Demo
</Button>
```

---

## 6. FIȘIERE BRAND

### În repository
```
docs/branding/
├── BRANDING-NOTES.md              # Acest fișier
└── logo-concepts/
    └── generativa-logo-final-dark.png  # Referință PNG

frontend/
├── src/components/common/
│   └── Logo.astro                 # ✅ Logo SVG implementat
├── public/
│   ├── favicon.svg                # ✅ Favicon actualizat
│   └── images/
│       └── generativa-logo.png    # PNG pentru fallback
└── tailwind.config.mjs            # ✅ Culori brand
```

### De creat (TODO)
- [ ] OG Image pentru social sharing (1200x630)
- [ ] Favicon PNG variants (16x16, 32x32, 180x180)
- [ ] Logo varianta icon-only

---

## 7. ISTORIC ITERAȚII

| Iterație | Descriere | Status |
|----------|-----------|--------|
| 1 | Rețea neurală, purple | ❌ Culori nepotrivite |
| 2 | Hexagon geometric | ❌ "Prea colțuros" |
| 3 | G din noduri | ⚠️ G arăta ca C |
| 4 | G solid + noduri orbitale | ✅ **FINAL** |

### Inspirație
- ElevenLabs - typography ALL CAPS
- Linear - gradients moderne
- Vercel - minimal, premium

---

## 8. CHECKLIST IMPLEMENTARE

### ✅ Completat
- [x] Paletă culori definită
- [x] Logo SVG creat (Logo.astro)
- [x] Header actualizat
- [x] Footer actualizat
- [x] Button variant gradient
- [x] Favicon actualizat
- [x] Traduceri actualizate (ro.json, en.json)
- [x] Tailwind config actualizat
- [x] Global CSS actualizat

### ⏳ Pending
- [ ] Achiziție domeniu generativa.ro
- [ ] OG Image (1200x630)
- [ ] Favicon PNG variants

---

## 9. DESIGN PATTERNS ADĂUGATE (Februarie 2026)

### Secțiuni Dark (stil Stripe)
Folosite în: `IntegrationHub.astro`

```css
/* Background gradient - NU solid black */
background: linear-gradient(to-br, #0a1628, #0f172a, #1e1b4b);

/* Dot pattern overlay */
background-image: radial-gradient(rgba(148, 163, 184, 0.15) 1px, transparent 1px);
background-size: 24px 24px;

/* Gradient orbs pentru depth */
.orb {
  background: rgba(34, 211, 238, 0.1); /* cyan */
  /* sau */
  background: rgba(139, 92, 246, 0.1); /* purple */
  filter: blur(60px);
}
```

### Glassmorphism Cards
Folosite în: `IntegrationHub.astro`

```css
.glass-card {
  background: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(4px);
}

.glass-card:hover {
  background: rgba(255, 255, 255, 0.1);
  border-color: rgba(34, 211, 238, 0.3);
  box-shadow: 0 10px 40px rgba(34, 211, 238, 0.1);
}
```

### Linii Animate (SVG)
Folosite în: `IntegrationHub.astro`

```css
/* SVG path */
stroke: url(#gradient);
stroke-dasharray: 8 4;

@keyframes dash {
  to { stroke-dashoffset: -24; }
}

.animated-line {
  animation: dash 2s linear infinite;
}
```

### Principii de Design (de la Stripe)

1. **Restraint elegant** - spațiu > decorații
2. **Gradient > Solid** - mereu adaugă subtilitate
3. **Dark ≠ Black** - folosește `#0a1628`, nu `#000`
4. **Animate subtil** - dashed lines, hover glow
5. **Glassmorphism** - transparency pentru modernitate

---

## 10. COMPONENTE VIZUALE NOI

| Component | Locație | Stil |
|-----------|---------|------|
| ChatSimulator | `components/demo/` | Light, cu gradient header |
| BenefitsStrip | `components/sections/` | Light background |
| UseCases | `components/sections/` | Light cu gradient subtle |
| IntegrationHub | `components/sections/` | Dark stil Stripe |

---

*Document actualizat: Februarie 2026 - Adăugate pattern-uri design de la Stripe*

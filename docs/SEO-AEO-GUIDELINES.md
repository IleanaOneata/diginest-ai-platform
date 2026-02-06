# GENERATIVA — Reguli SEO & AEO (Obligatorii)

> **Pentru AI în sesiuni noi**: Acest document conține TOATE regulile obligatorii pentru SEO (Search Engine Optimization) și AEO (Answer Engine Optimization). Citește-l **COMPLET** înainte de a crea sau modifica orice pagină.

## Document Version
- **Creat**: Februarie 2026
- **Ultima actualizare**: Februarie 2026
- **Status**: ✅ Activ — Reguli obligatorii

---

## 0. De Ce SEO + AEO?

### SEO = Search Engine Optimization
Optimizare pentru Google Search (clasic): meta tags, Schema.org, heading structure, keyword targeting.

### AEO = Answer Engine Optimization
Optimizare pentru **AI-powered search** (Google AI Overviews, ChatGPT Browse, Perplexity, Claude): răspunsuri directe la întrebări, lead paragraphs concise, FAQ structurate.

### Principiul Nostru
Fiecare pagină trebuie să fie **optimizată dual** — atât pentru crawlere clasice (Google Bot) cât și pentru AI Overviews / Featured Snippets. Tehnicile se completează: ce e bun pentru AEO e bun și pentru SEO.

---

## 1. Reguli Meta Tags (OBLIGATORII)

### 1.1 Title Tag

| Regulă | Specificație |
|--------|--------------|
| **Lungime** | 50-70 caractere (max 70, ideal 60) |
| **Format** | `[Cuvânt cheie principal] | [Diferențiator] | GENERATIVA` |
| **Cuvânt cheie** | Întotdeauna la ÎNCEPUT |
| **Brand** | `GENERATIVA` la final, separat cu `|` |
| **Unicitate** | Fiecare pagină TREBUIE să aibă title unic |

**Exemple corecte:**
```
"Automatizare Procese AI | Soluții Business | GENERATIVA"  (55 chars)
"Agenți Conversaționali AI | Asistenți Vocali & Chat 24/7 | GENERATIVA" (66 chars)
"Contact - GENERATIVA"  (20 chars — OK pentru pagini utilitare)
```

**Exemple GREȘITE:**
```
"GENERATIVA - Automatizare" ← brand la început, cuvânt cheie la final
"Pagina de Servicii" ← generic, fără keywords
"Automatizare Procese AI pentru Business-uri din România cu Agenți Inteligenți | GENERATIVA" ← prea lung (90+ chars)
```

### 1.2 Meta Description

| Regulă | Specificație |
|--------|--------------|
| **Lungime** | 140-160 caractere (nu mai mult de 160!) |
| **Conținut** | Răspunde la "De ce să dau click?" |
| **CTA implicit** | Include o acțiune: "Solicită demo", "Consultanță gratuită" |
| **Cuvinte cheie** | Integrează natural 2-3 keywords |
| **Unicitate** | Fiecare pagină TREBUIE să aibă description unică |

**Exemplu corect (RO, 158 chars):**
```
"Agenți AI care răspund la telefon, WhatsApp și email 24/7 în limba română. Programări automate, integrare CRM, zero apeluri pierdute. Solicită un demo gratuit."
```

### 1.3 Canonical URL

| Regulă | Specificație |
|--------|--------------|
| **Obligatoriu** | Pe FIECARE pagină |
| **Format** | Path relativ: `/ro/servicii/automatizare-procese/` |
| **Trailing slash** | ÎNTOTDEAUNA cu `/` la final |
| **Self-referencing** | Canonical = URL-ul paginii curente |

---

## 2. Heading Structure (H1-H6) — Reguli OBLIGATORII

### 2.1 H1 — Un singur H1 per pagină

| Regulă | Specificație |
|--------|--------------|
| **Câte** | Exact **1 (unu)** H1 per pagină |
| **Unde** | În secțiunea Hero |
| **Conținut** | Cuvântul cheie principal al paginii |
| **Lungime** | Max 60-70 caractere |

### 2.2 H2 — Question-Based (CRITIC pentru AEO)

**Aceasta este regula cea mai importantă pentru AEO.**

| Regulă | Specificație |
|--------|--------------|
| **Format** | Întrebare directă, așa cum ar căuta userul pe Google |
| **Sursa** | People Also Ask (PAA), Google Autocomplete, AnswerThePublic |
| **Limbă** | Formulare naturală, nu keyword stuffing |
| **Rol** | Fiecare H2 = un potential Featured Snippet / AI Overview answer |

**Exemple corecte (question-based H2):**
```html
<h2>Ce face un agent conversational AI pentru afacerea ta?</h2>
<h2>Cum funcționează un agent vocal AI în practică?</h2>
<h2>Ce rezultate aduce automatizarea proceselor cu AI?</h2>
<h2>Cât costă un agent conversational AI?</h2>
```

**Exemple GREȘITE:**
```html
<h2>Serviciile Noastre</h2>          ← generic, nu e întrebare
<h2>Features</h2>                    ← English pe pagina RO, generic
<h2>Automatizare AI Business</h2>    ← keyword stuffing, nu e întrebare
```

### 2.3 H3-H6 — Sub-secțiuni

- H3: Titluri de carduri, sub-categorii
- H4-H6: Rar folosite, doar pentru conținut foarte detaliat (articole blog)

### 2.4 Ierarhie STRICT Respectată

```
H1 (1x per pagină)
  H2 (secțiuni principale — question-based)
    H3 (sub-secțiuni, titluri carduri)
      H4 (opțional, sub-sub-secțiuni)
```

**NICIODATĂ** H3 fără H2 deasupra, H4 fără H3 deasupra etc.

---

## 3. Answer-First Lead Paragraphs (CRITIC pentru AEO)

### Ce Sunt

Imediat după fiecare H2, trebuie un **paragraf lead** care **răspunde direct la întrebare** în 40-60 cuvinte. Acest paragraf este cel pe care Google/AI îl extrage pentru Featured Snippets și AI Overviews.

### Reguli

| Regulă | Specificație |
|--------|--------------|
| **Lungime** | 40-60 cuvinte (STRICT!) |
| **Conținut** | Răspuns direct, fără introducere |
| **Ton** | Factual, informativ, nu vânzare |
| **Prima propoziție** | Răspunsul complet în forma cea mai scurtă |
| **Keywords** | 2-3 keywords naturale integrate |

### Exemplu Corect

```html
<h2>Ce face un agent conversational AI pentru afacerea ta?</h2>
<p class="text-body-lg text-neutral-600">
  Un agent conversational AI preia apelurile telefonice, mesajele pe WhatsApp și
  emailurile clienților tăi, 24 de ore din 24. Identifică automat intenția
  fiecărui contact — programare, întrebare, reclamație — și execută acțiuni
  concrete: creează programări în calendar, actualizează CRM-ul, trimite
  confirmări.
</p>
```

### Exemplu GREȘIT

```html
<h2>Ce face un agent conversational AI pentru afacerea ta?</h2>
<p>
  La GENERATIVA, suntem mândri să oferim cele mai bune soluții AI...
</p>
<!-- ❌ Nu răspunde la întrebare! Promovare, nu informație. -->
```

---

## 4. Schema.org Structured Data (OBLIGATORIU)

### 4.1 Pattern-ul `@graph`

**TOATE paginile** folosesc pattern-ul `@graph` care combină multiple scheme într-un singur obiect JSON-LD. BaseLayout gestionează afișarea:

```typescript
// BaseLayout face: [organizationSchema, schema] → 2 <script type="application/ld+json">
// Primul: Organization (global, adăugat automat de BaseLayout)
// Al doilea: @graph cu schemele paginii curente
```

### 4.2 Schema.org per Tip de Pagină

#### Homepage (`/ro/`, `/en/`)
```typescript
'@graph': [
  { '@type': 'WebSite' },      // name, url, description, inLanguage, publisher
  { '@type': 'WebPage' },      // name, url, description, inLanguage, isPartOf
  { '@type': 'BreadcrumbList' } // itemListElement: [{ Acasa }]
]
```

#### About Page (`/ro/despre/`, `/en/about/`)
```typescript
'@graph': [
  {
    '@type': 'AboutPage',       // name, url, description, inLanguage, isPartOf
    about: {
      '@type': 'Organization',  // foundingDate, areaServed, knowsAbout, slogan
    }
  },
  { '@type': 'BreadcrumbList' } // Acasa → Despre Noi
]
```

#### Contact Page (`/ro/contact/`, `/en/contact/`)
```typescript
'@graph': [
  { '@type': 'ContactPage' },   // name, url, description, inLanguage, isPartOf
  {
    '@type': 'Organization',
    contactPoint: {
      '@type': 'ContactPoint',   // contactType, email, availableLanguage, areaServed
    }
  },
  { '@type': 'BreadcrumbList' }  // Acasa → Contact
]
```

#### Service Pages (`/ro/servicii/*/`, `/en/services/*/`)
```typescript
'@graph': [
  {
    '@type': 'Service',          // name, description, provider, areaServed, serviceType
    offers: { '@type': 'Offer' },
    // Optional: hasOfferCatalog pentru sub-servicii
    // Optional: audience: { '@type': 'BusinessAudience' }
  },
  {
    '@type': 'FAQPage',          // mainEntity: [{ Question, acceptedAnswer: Answer }]
  },
  {
    '@type': 'BreadcrumbList',   // Acasa → Servicii → [Nume Serviciu] (3 nivele)
  },
  {
    '@type': 'HowTo',           // name, description, step: [{ HowToStep }]
  }
]
```

### 4.3 Reguli Schema.org OBLIGATORII

| Regulă | Specificație |
|--------|--------------|
| **`@context`** | `'https://schema.org'` — obligatoriu la root |
| **`@id`** | Unic per pagină, format: `${siteUrl}/path/#type` |
| **`@graph`** | Array cu toate schemele paginii |
| **`inLanguage`** | `'ro-RO'` sau `'en-US'` — obligatoriu pe WebPage/AboutPage/ContactPage |
| **`isPartOf`** | Referință la `${siteUrl}/#website` |
| **`provider`** | Pe Service: referință la `${siteUrl}/#organization` |
| **`name` + `description`** | Obligatorii pe TOATE tipurile de scheme |

### 4.4 BreadcrumbList — Structură Standard

```typescript
{
  '@type': 'BreadcrumbList',
  '@id': `${siteUrl}/${locale}/path/#breadcrumb`,
  itemListElement: [
    {
      '@type': 'ListItem',
      position: 1,
      name: 'Acasa',       // sau 'Home' pentru EN
      item: `${siteUrl}/${locale}/`,
    },
    {
      '@type': 'ListItem',
      position: 2,
      name: 'Servicii',    // sau 'Services'
      item: `${siteUrl}/${locale}/servicii/`,  // Cu URL pentru paginile intermediare
    },
    {
      '@type': 'ListItem',
      position: 3,
      name: 'Automatizare Procese', // Pagina curentă — FĂRĂ `item`
    },
  ],
}
```

**Reguli Breadcrumb:**
- Ultimul element **NU** are `item` (e pagina curentă)
- Fiecare nivel intermediar ARE `item` cu URL-ul paginii respective
- `position` începe de la 1
- Numele corespund cu navigarea vizuală din pagină

### 4.5 FAQPage Schema

```typescript
{
  '@type': 'FAQPage',
  '@id': `${siteUrl}/path/#faq`,
  mainEntity: faqItems.map((item) => ({
    '@type': 'Question',
    name: item.question,
    acceptedAnswer: {
      '@type': 'Answer',
      text: item.answer,
    },
  })),
}
```

**Reguli FAQ:**
- Minim **6 întrebări** per pagină de serviciu
- Întrebările targetează **People Also Ask** (căutări reale)
- Răspunsurile sunt **complete dar concise** (2-4 propoziții)
- Include întrebări despre: cost, durată, ROI, angajați, securitate, integrări

### 4.6 HowTo Schema (Service Pages)

```typescript
{
  '@type': 'HowTo',
  '@id': `${siteUrl}/path/#howto`,
  name: 'Cum implementăm [serviciul]',
  description: 'Pașii pentru implementarea [serviciul]',
  step: steps.map((step, index) => ({
    '@type': 'HowToStep',
    position: index + 1,
    name: step.title,
    text: step.description,
  })),
}
```

### 4.7 Service Schema cu Offer Catalog (Opțional)

Când un serviciu are **sub-servicii distincte**, folosește `hasOfferCatalog`:

```typescript
{
  '@type': 'Service',
  hasOfferCatalog: {
    '@type': 'OfferCatalog',
    name: 'Soluții Conversational AI',
    itemListElement: [
      {
        '@type': 'Offer',
        itemOffered: {
          '@type': 'Service',
          name: 'Voice AI Agent',
          description: '...',
        },
      },
      // ... alte sub-servicii
    ],
  },
}
```

---

## 5. FAQ Section — Reguli Implementare

### 5.1 Conținut FAQ

| Regulă | Specificație |
|--------|--------------|
| **Minim** | 6 întrebări per pagină de serviciu, 8 pentru pagini complexe |
| **Sursa întrebărilor** | People Also Ask, Google Autocomplete, AnswerThePublic |
| **Tipuri de întrebări** | Cost, funcționalitate, implementare, ROI, securitate, diferențiere |
| **Răspunsuri** | 2-4 propoziții, factuale, cu numere concrete când e posibil |
| **Limba** | Naturală, nu marketing speak |

### 5.2 FAQ Accordion — Naming Convention

**CRITIC**: Fiecare pagină cu FAQ trebuie să aibă selectori unici pentru a evita coliziuni JavaScript.

| Pagina | Data Attribute | Icon Classes | Function Name |
|--------|---------------|--------------|---------------|
| Homepage | `data-faq-trigger` | `faq-icon-plus`, `faq-icon-minus` | (inline DOMContentLoaded) |
| Automatizare Procese | `data-service-faq-trigger` | `service-faq-icon-plus`, `service-faq-icon-minus` | `initServiceFaqAccordion` |
| Agenți Conversaționali | `data-conv-faq-trigger` | `conv-faq-icon-plus`, `conv-faq-icon-minus` | `initConvFaqAccordion` |
| [Pagină Nouă] | `data-[prefix]-faq-trigger` | `[prefix]-faq-icon-plus`, `[prefix]-faq-icon-minus` | `init[Prefix]FaqAccordion` |

**Convenție de Naming:**
- Prefix scurt derivat din slug-ul paginii: `conv` (conversational), `service` (automation), `integ` (integrations)
- NICIODATĂ nu reutiliza un selector existent!

### 5.3 FAQ Schema Duplicare

- Homepage-ul are FAQ propriu (din `t.faq.items`) cu schema inline în `FAQ.astro`
- Service pages au FAQ propriu (din `t.serviceAutomation.faq.items` etc.) cu schema în page shell
- **NU e duplicare** — sunt date diferite, pagini diferite, scheme diferite
- Google indexează fiecare pagină separat

---

## 6. Keyword Strategy

### 6.1 Structura Keywords per Pagină

Fiecare pagină de serviciu targetează:

| Tip Keyword | Exemplu | Unde Apare |
|-------------|---------|------------|
| **Primary** (1) | "automatizare procese AI" | H1, title, meta description, first paragraph |
| **Secondary** (2-3) | "automatizare business România", "RPA AI" | H2s, lead paragraphs |
| **Long-tail** (5-8) | "cât costă automatizarea cu AI", "cum funcționează RPA" | FAQ questions, body text |
| **LSI** (semantic) | "eficiență operațională", "reducere costuri", "digitalizare" | Natural în text |

### 6.2 Keyword Research Process

1. **Google Search** — caută termenul principal, notează People Also Ask
2. **Google Autocomplete** — tastează termenul, notează sugestiile
3. **Competitorii** — verifică Agentic.ro, Inflate.agency pentru keywords
4. **Long-tail** — combină: "ce/cum/cât/de ce" + keyword principal

### 6.3 Keyword Density

- **Nu** keyword stuffing!
- Keyword primar: 1-2% din text (natural)
- Keywords secundare: 0.5-1%
- Focusează pe **relevanță** și **naturalitate**, nu pe densitate

---

## 7. Traduceri i18n — Structura Obligatorie pentru Pagini de Serviciu

### 7.1 Bloc Standard în `ro.json` / `en.json`

Fiecare pagină de serviciu trebuie să aibă acest bloc în fișierele de traduceri:

```json
"serviceNume": {
  "meta": {
    "title": "...",           // Title tag (50-70 chars)
    "description": "...",     // Meta description (140-160 chars)
    "schemaName": "...",      // Service schema name
    "schemaDescription": "...", // Service schema description
    "schemaOffer": "...",     // Offer description
    "breadcrumbName": "..."   // Breadcrumb display name
  },
  "breadcrumb": {
    "home": "Acasa",
    "services": "Servicii",
    "current": "Nume Serviciu"
  },
  "hero": {
    "eyebrow": "...",
    "title": "...",           // H1 — main keyword
    "subtitle": "...",        // 40-60 cuvinte, answer-first
    "cta": "..."
  },
  "capabilities": {           // Sau orice secțiune principală
    "title": "...",           // H2 — question-based
    "lead": "...",            // 40-60 cuvinte, answer-first
    "swipeHint": "...",       // "Glisează pentru mai multe"
    "items": [...]
  },
  "approach": {
    "title": "...",           // H2 — question-based
    "lead": "...",
    "schemaName": "...",      // HowTo schema name
    "schemaDescription": "...", // HowTo schema description
    "steps": [...]
  },
  "benefits": {
    "title": "...",           // H2 — question-based
    "lead": "...",
    "items": [...]
  },
  "faq": {
    "title": "...",
    "lead": "...",
    "items": [
      { "question": "...", "answer": "..." }
      // Minim 6, recomandat 8
    ]
  },
  "cta": {
    "title": "...",
    "subtitle": "...",
    "button": "..."
  }
}
```

### 7.2 i18n Path Mappings

Când adaugi o pagină nouă, **OBLIGATORIU** adaugă mapări în `src/i18n/index.ts`:

```typescript
// Adaugă AMBELE direcții (RO slug → mapping, EN slug → mapping)
'slug-romanesc': { ro: 'slug-romanesc', en: 'english-slug' },
'english-slug': { ro: 'slug-romanesc', en: 'english-slug' },
```

**Fără aceste mapări, Language Switcher-ul va genera 404!**

---

## 8. Page Shell Template — Service Pages

### 8.1 Template Standard (Copiază și Adaptează)

```astro
---
/**
 * [Limba] [Nume Serviciu] Service Page
 *
 * SEO/AEO optimized service detail page for GENERATIVA
 * Target keywords: [keyword1], [keyword2], [keyword3]
 *
 * Schema.org: Service + FAQPage + BreadcrumbList + HowTo (@graph pattern)
 */

import BaseLayout from '@layouts/BaseLayout.astro';
import [ComponentName] from '@components/sections/[ComponentName].astro';
import { getTranslations } from '@i18n/index';

const locale = '[ro|en]';
const t = getTranslations(locale);
const s = t.[serviceKey];  // Alias scurt: sa, sc, si etc.

const title = s.meta.title;
const description = s.meta.description;

const siteUrl = 'https://diginest-ai-platform.vercel.app';

const schema = {
  '@context': 'https://schema.org',
  '@graph': [
    // 1. Service
    { '@type': 'Service', /* ... */ },
    // 2. FAQPage
    { '@type': 'FAQPage', /* ... */ },
    // 3. BreadcrumbList
    { '@type': 'BreadcrumbList', /* ... */ },
    // 4. HowTo
    { '@type': 'HowTo', /* ... */ },
  ],
};
---

<BaseLayout
  title={title}
  description={description}
  locale={locale}
  canonicalUrl="/[locale]/[path]/"
  schema={schema}
>
  <[ComponentName] locale={locale} />
</BaseLayout>
```

### 8.2 Checklist pentru Fiecare Pagină Nouă

Când creezi o pagină de serviciu nouă, verifică TOATE:

- [ ] **ro.json** — bloc `serviceNume` cu meta, breadcrumb, hero, secțiuni, faq, cta
- [ ] **en.json** — bloc echivalent în engleză
- [ ] **i18n/index.ts** — path mappings adăugate (ambele direcții)
- [ ] **Component.astro** — componenta principală cu toate secțiunile
- [ ] **pages/ro/servicii/slug.astro** — page shell RO cu Schema.org @graph
- [ ] **pages/en/services/slug.astro** — page shell EN cu Schema.org @graph
- [ ] **CLAUDE.md** — actualizat: Ce s-a implementat, 404 table, project structure, session history
- [ ] **H1** — exact 1 per pagină, keyword principal
- [ ] **H2s** — toate question-based
- [ ] **Lead paragraphs** — 40-60 cuvinte, answer-first
- [ ] **Meta title** — 50-70 chars, keyword la început
- [ ] **Meta description** — 140-160 chars, cu CTA
- [ ] **Canonical URL** — cu trailing slash
- [ ] **Schema @graph** — Service + FAQPage + BreadcrumbList + HowTo
- [ ] **FAQ accordion** — selector unic `data-[prefix]-faq-trigger`
- [ ] **Mobile scroll** — `flex md:grid overflow-x-auto snap-x scrollbar-hide`
- [ ] **Dark sections** — `text-white` explicit pe headings
- [ ] **Language Switcher** — funcționează RO ↔ EN
- [ ] **Build** — `npm run build` fără erori
- [ ] **Header/Footer** — link-urile duc la pagină

---

## 9. Content Guidelines pentru AEO

### 9.1 Structura Ideală per Secțiune

```
[H2 — Întrebare directă din People Also Ask]
[Lead Paragraph — 40-60 cuvinte, răspuns direct]
[Conținut detaliat — carduri, liste, explicații]
```

### 9.2 Tipuri de Întrebări Recomandate

| Tip | Format | Exemplu |
|-----|--------|---------|
| **Ce** (definitional) | "Ce este/face X?" | "Ce face un agent conversational AI?" |
| **Cum** (procedural) | "Cum funcționează X?" | "Cum funcționează automatizarea cu AI?" |
| **Cât** (cost/ROI) | "Cât costă X?" | "Cât costă un agent conversational AI?" |
| **De ce** (beneficii) | "De ce să folosesc X?" | "De ce să automatizez procesele cu AI?" |
| **Care** (comparison) | "Care sunt beneficiile X?" | "Care sunt avantajele AI față de angajați?" |

### 9.3 Scrie pentru AI Overviews

Google AI Overviews extrage informații din pagini care:

1. **Răspund direct** — prima propoziție e răspunsul
2. **Sunt structurate** — heading-uri clare, liste, tabele
3. **Sunt factuale** — numere concrete, nu promisiuni vagi
4. **Sunt concise** — 40-60 cuvinte per paragraf lead
5. **Au autoritate** — Schema.org valid, site de încredere

### 9.4 Format Preferat pentru Răspunsuri

```html
<!-- BINE: Definitional answer -->
<p>Un agent conversational AI este un sistem software care comunică automat
cu clienții prin voce, chat sau email, folosind procesarea limbajului natural
(NLP) pentru a înțelege și răspunde la cereri.</p>

<!-- BINE: Numbered steps -->
<ol>
  <li>Analizăm fluxurile existente de comunicare</li>
  <li>Configurăm și antrenăm agentul AI</li>
  <li>Testăm pe un canal unic (pilot)</li>
  <li>Lansăm și scalăm pe toate canalele</li>
</ol>

<!-- BINE: Factual with numbers -->
<p>Implementarea durează 2-4 săptămâni. Clienții noștri raportează o
reducere de 70% a volumului de apeluri repetitive și un cost per
interacțiune cu 60% mai mic față de operatorii umani.</p>
```

---

## 10. Pagini Existente — Referință Rapidă

### Schema Mapping Curent

| Pagină | URL RO | Scheme în @graph | Status |
|--------|--------|-----------------|--------|
| Homepage | `/ro/` | WebSite + WebPage + BreadcrumbList | ✅ |
| About | `/ro/despre/` | AboutPage (cu Organization) + BreadcrumbList | ✅ |
| Contact | `/ro/contact/` | ContactPage + Organization (ContactPoint) + BreadcrumbList | ✅ |
| Automatizare Procese | `/ro/servicii/automatizare-procese/` | Service + FAQPage + BreadcrumbList + HowTo | ✅ |
| Agenți Conversaționali | `/ro/servicii/agenti-conversationali/` | Service + FAQPage + BreadcrumbList + HowTo | ✅ |

### siteUrl Standard

```typescript
const siteUrl = 'https://diginest-ai-platform.vercel.app';
```

**IMPORTANT**: Când se achiziționează `generativa.ro`, TOATE referințele `siteUrl` trebuie actualizate. Sunt prezente în:
- Fiecare page shell (homepage, about, contact, service pages)
- BaseLayout.astro (Organization schema)

---

## 11. Validare și Testing

### 11.1 Pre-Deploy Checklist SEO

Rulează după fiecare pagină nouă sau modificare majoră:

```bash
# 1. Build fără erori
cd frontend && npm run build

# 2. Verifică schema.org (view source pe pagină)
# Caută: <script type="application/ld+json">
# Trebuie să fie 2: Organization + @graph

# 3. Verifică meta tags (view source)
# <title> — 50-70 chars
# <meta name="description"> — 140-160 chars
# <link rel="canonical"> — cu trailing slash

# 4. Verifică heading structure
# Exact 1x H1, multiple H2 (question-based), H3 sub H2
```

### 11.2 Tools de Validare Online

| Tool | URL | Ce Verifică |
|------|-----|-------------|
| **Schema Validator** | https://validator.schema.org/ | Schema.org syntax |
| **Rich Results Test** | https://search.google.com/test/rich-results | Eligibilitate rich results |
| **PageSpeed Insights** | https://pagespeed.web.dev/ | Core Web Vitals + SEO |
| **Ahrefs Webmaster** | https://ahrefs.com/webmaster-tools | SEO audit complet |
| **Screaming Frog** | https://www.screamingfrog.co.uk/seo-spider/ | Crawl complet site |

### 11.3 Post-Deploy Verificare

După push pe staging/producție:

1. **View Source** → verifică `<script type="application/ld+json">` (2 blocuri)
2. **Rich Results Test** → testează URL-ul de staging
3. **Mobile check** → deschide pe telefon, verifică titluri, breadcrumb
4. **Language Switcher** → comută RO ↔ EN, verifică URL-uri corecte

---

## 12. Reguli de Evitat (DO NOT)

| ❌ Nu Face | ✅ Fă Asta |
|-----------|-----------|
| H2 generic ("Servicii") | H2 question-based ("Ce servicii oferim?") |
| Lead paragraph vag ("Suntem cei mai buni...") | Lead paragraph factual cu răspuns direct |
| Title >70 chars | Title 50-70 chars cu keyword la început |
| Description >160 chars | Description 140-160 chars cu CTA |
| Schema fără `@id` | Fiecare schema cu `@id` unic |
| FAQ cu 2-3 întrebări | FAQ cu 6-8 întrebări din PAA |
| Keyword stuffing | Keywords naturale, 1-2% densitate |
| Duplicate meta tags | Fiecare pagină cu title + description unice |
| BreadcrumbList fără Organization reference | `isPartOf: { '@id': '${siteUrl}/#website' }` |
| FAQ selector reutilizat | Selector unic per pagină (`data-[prefix]-faq-trigger`) |

---

## 13. Checklist Rapid (Print-Friendly)

### La Fiecare Pagină Nouă:
- [ ] Title: 50-70 chars, keyword la început, brand la final
- [ ] Description: 140-160 chars, CTA inclus
- [ ] Canonical URL cu trailing slash
- [ ] Exact 1× H1 cu keyword principal
- [ ] Toate H2 sunt question-based
- [ ] Lead paragraph 40-60 cuvinte după fiecare H2
- [ ] Schema.org @graph cu tipurile corecte
- [ ] BreadcrumbList cu structura corectă
- [ ] FAQ: 6-8 întrebări din People Also Ask
- [ ] FAQ accordion cu selector unic
- [ ] Path mappings în i18n/index.ts
- [ ] Traduceri complete RO + EN
- [ ] Mobile scroll pattern pe carduri
- [ ] Dark sections: text-white explicit
- [ ] Build clean, zero erori
- [ ] Language Switcher funcțional

---

*Document de referință obligatoriu — actualizează la fiecare pagină nouă sau schimbare de pattern.*
*Ultima actualizare: Februarie 2026*

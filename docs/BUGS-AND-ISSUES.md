# BUGS & ISSUES TRACKER

> **Status**: Creat Februarie 2026 din analiza completă a proiectului.
> **Scop**: Centralizare toate bug-urile, problemele tehnice și referințele outdated pentru rezolvare sistematică.

---

## Legendă Priorități

| Emoji | Prioritate | Descriere |
|-------|-----------|-----------|
| P0 | CRITIC | Afectează funcționalitatea sau datele utilizatorilor |
| P1 | IMPORTANT | Afectează SEO, branding sau experiența utilizator |
| P2 | MEDIU | Probleme tehnice care nu afectează utilizatorul direct |
| P3 | LOW | Cleanup, naming, cod nefolosit |

---

## BACKEND BUGS

### BUG-001: Double-percent in demo email HTML template [P2]
- **Fișier**: `backend/src/main/java/com/diginest/aiagents/service/EmailService.java`
- **Metodă**: `buildDemoConfirmationHtml()`
- **Problemă**: Template-ul HTML folosește `100%%` în atributele `width` ale tabelelor. Metoda folosește `.replace()` (nu `String.format()`), deci `%%` NU este interpretat și apare literal ca `width="100%%"` în email-ul trimis.
- **Comparație**: `buildConfirmationHtml()` (contact form) folosește corect `100%`.
- **Impact**: Cosmetic — browserele de email tolerează probabil `100%%`, dar este tehnic incorect.
- **Fix**: Înlocuiește `100%%` cu `100%` în `buildDemoConfirmationHtml()`.
- [ ] REZOLVAT

### BUG-002: Ordinea greșită în sanitize() — double-encoding [P0]
- **Fișiere**: `backend/src/main/java/com/diginest/aiagents/service/ContactService.java`, `DemoService.java`
- **Metodă**: `sanitize()`
- **Problemă**: Ordinea curentă este: `<` → `&lt;`, `>` → `&gt;`, apoi `&` → `&amp;`. Asta înseamnă că `&lt;` devine `&amp;lt;` (double-encoded). Ordinea corectă: `&` PRIMUL, apoi `<` și `>`.
- **Impact**: Orice input de la utilizator care conține `<`, `>` sau `&` va fi stocat incorect în baza de date.
- **Fix**: Mută replace-ul `&` → `&amp;` ÎNAINTE de `<` → `&lt;` și `>` → `&gt;`.
- [ ] REZOLVAT

### BUG-003: Double HTML escaping între service și email [P1]
- **Fișiere**: `ContactService.java` (sanitize) + `EmailService.java` (escapeHtml)
- **Problemă**: Conținutul utilizatorului este escapuit HTML de două ori:
  1. `ContactService.sanitize()` escapează `&`, `<`, `>` la salvarea în DB
  2. `EmailService.escapeHtml()` escapează din nou la construirea email-ului HTML
- **Rezultat**: Un `&` introdus de utilizator → stocat ca `&amp;` → afișat în email ca `&amp;amp;`
- **Impact**: Datele din baza de date sunt permanent HTML-encoded (nu raw), iar email-urile afișează entități HTML vizibile.
- **Fix**: Două opțiuni:
  - A) Elimină `sanitize()` din service, păstrează doar `escapeHtml()` la afișare (recomandat — stochează date raw)
  - B) Elimină `escapeHtml()` din email, păstrează `sanitize()` (mai puțin ideal — datele din DB rămân encoded)
- [ ] REZOLVAT

---

## FRONTEND BUGS

### BUG-004: Fișier site.webmanifest lipsă — 404 [P1]
- **Fișier**: `frontend/src/layouts/BaseLayout.astro`
- **Linia**: `<link rel="manifest" href="/site.webmanifest">`
- **Problemă**: Fișierul `/site.webmanifest` este referit în BaseLayout dar NU există în `frontend/public/`. Browserele generează un 404 la fiecare page load.
- **Fix**: Creează `frontend/public/site.webmanifest` cu metadata corectă (name, icons, theme_color) SAU elimină linia din BaseLayout.
- [ ] REZOLVAT

### BUG-005: OG Image lipsă — social shares fără imagine [P1]
- **Fișier**: `frontend/src/layouts/BaseLayout.astro`
- **Problemă**: Default `ogImage` prop este `'/images/og-image.png'`, dar fișierul NU există în `frontend/public/images/`. Share-urile pe social media (Facebook, LinkedIn, Twitter) vor fi fără imagine.
- **Fix**: Creează imagine OG 1200x630 cu branding GENERATIVA (Deep Slate + Amber) și plasează în `frontend/public/images/og-image.png`.
- [ ] REZOLVAT

### BUG-006: robots.txt referă domeniu vechi [P1]
- **Fișier**: `frontend/public/robots.txt`
- **Problemă**: Conține `Sitemap: https://diginest.ai/sitemap-index.xml` — domeniu vechi care nu mai este relevant. În plus, sitemap-ul este dezactivat în astro.config.mjs.
- **Fix**: Actualizează cu URL-ul corect sau elimină linia de sitemap până când sitemap-ul este reactivat.
- [ ] REZOLVAT

### BUG-007: Sitemap dezactivat [P2]
- **Fișier**: `frontend/astro.config.mjs`
- **Problemă**: `@astrojs/sitemap` este comentat (`// sitemap()`). Nu se generează niciun sitemap.xml, ceea ce afectează indexarea Google.
- **Fix**: Decomentează integrarea sitemap și configurează URL-urile corecte.
- [ ] REZOLVAT

---

## OUTDATED REFERENCES (REBRANDING INCOMPLETE)

### BUG-008: README.md — încă menționează "Diginest AI" [P1]
- **Fișier**: `README.md` (root)
- **Problemă**: Titlul, descrierea, variabilele de environment și licența menționează "Diginest AI" / "diginest.ai" în loc de GENERATIVA / generativa.ro.
- **Fix**: Rescrie README.md cu branding GENERATIVA.
- [ ] REZOLVAT

### BUG-009: DEPLOYMENT.md — domenii și email-uri vechi [P2]
- **Fișier**: `docs/DEPLOYMENT.md`
- **Problemă**: Referă `diginest.ai`, `noreply@diginest.ai`, `api.diginest.ai`, `contact@diginest.ai`, `MAIL_PORT=587` (SMTP blocat pe Railway).
- **Fix**: Actualizează cu `generativa.ro`, `contact@generativa.ro`, și notă despre Resend HTTP API.
- [ ] REZOLVAT

### BUG-010: package.json name — "diginest-ai-frontend" [P3]
- **Fișier**: `frontend/package.json`
- **Problemă**: Câmpul `name` este `"diginest-ai-frontend"` în loc de `"generativa-frontend"`.
- **Fix**: Actualizează name-ul.
- [ ] REZOLVAT

### BUG-011: astro.config.mjs site URL — Vercel deployment URL [P2]
- **Fișier**: `frontend/astro.config.mjs`
- **Problemă**: `site: 'https://diginest-ai-platform.vercel.app'` — corect momentan (domeniul generativa.ro nu e achiziționat), dar trebuie actualizat la lansare.
- **Notă**: Acest URL se propagă în canonical URLs, hreflang, și Schema.org din toate page shells.
- **Fix**: Actualizează când domeniul generativa.ro este activ. Necesită modificări în ~12+ fișiere.
- [ ] REZOLVAT

---

## FIȘIERE INUTILE / CLEANUP

### BUG-012: Fișierul `nul` în root repository [P2]
- **Fișiere**: `nul` (root), `frontend/nul`
- **Problemă**: Pe Windows, `nul` este un device name rezervat. Railway CLI crashează cu `Incorrect function. (os error 1)` la procesarea acestuia. Git pe Windows poate avea probleme la ștergere.
- **Fix**: `git rm nul frontend/nul` (posibil necesită alt OS sau WSL).
- [ ] REZOLVAT

### BUG-013: Favicon-uri duplicate în public/ [P3]
- **Fișiere**: `frontend/public/favicon-32.png` + `favicon-32x32.png`, `favicon-16.png` + `favicon-16x16.png`
- **Problemă**: Există versiuni duplicate cu naming diferit. BaseLayout referă doar `favicon-32.png` și `favicon-16.png`.
- **Fix**: Șterge `favicon-32x32.png` și `favicon-16x16.png` (duplicatele nereferate).
- [ ] REZOLVAT

### BUG-014: favicon.svg vechi încă în repository [P3]
- **Fișier**: `frontend/public/favicon.svg`
- **Problemă**: Nu mai este referit în BaseLayout (înlocuit cu PNG), dar fișierul există încă.
- **Fix**: Șterge `favicon.svg` sau păstrează-l ca backup (low priority).
- [ ] REZOLVAT

---

## COD NEFOLOSIT (BACKEND)

### BUG-015: Metode nefolosite în RateLimitConfig [P3]
- **Fișier**: `backend/src/main/java/com/diginest/aiagents/config/RateLimitConfig.java`
- **Problemă**: `resolveNewsletterBucket()` și `resolveGeneralBucket()` nu sunt apelate din niciun controller. `cleanupOldBuckets()` nu este programat.
- **Fix**: Elimină sau conectează la controllere viitoare.
- [ ] REZOLVAT

### BUG-016: Dependență spring-boot-starter-mail nefolosită [P3]
- **Fișier**: `backend/pom.xml`
- **Problemă**: `spring-boot-starter-mail` este încă dependență, dar EmailService folosește RestTemplate direct (Resend HTTP API), nu JavaMailSender.
- **Fix**: Elimină dependența din pom.xml (verifică că `management.health.mail.enabled=false` rămâne setat).
- [ ] REZOLVAT

### BUG-017: allowedOrigins parsate dar nefolosite în CorsConfig [P3]
- **Fișier**: `backend/src/main/java/com/diginest/aiagents/config/CorsConfig.java`
- **Problemă**: Câmpul `allowedOrigins` este parsat din environment dar `*` (wildcard) este hardcodat în loc.
- **Fix**: Folosește `allowedOrigins` din configurare SAU elimină câmpul nefolosit.
- [ ] REZOLVAT

### BUG-018: Lombok declarat dar nefolosit [P3]
- **Fișier**: `backend/pom.xml`
- **Problemă**: Lombok este în dependencies dar nicio clasă nu folosește annotations Lombok (`@Data`, `@Getter`, etc.).
- **Fix**: Elimină din pom.xml sau adoptă în entities/DTOs.
- [ ] REZOLVAT

---

## UX / CONȚINUT

### BUG-019: Link-uri social media placeholder în Footer [P2]
- **Fișier**: `frontend/src/components/common/Footer.astro`
- **Problemă**: LinkedIn, Facebook, Instagram pointează la URL-uri presupuse (`https://linkedin.com/company/generativa`) care pot să nu existe.
- **Fix**: Creează paginile sociale SAU elimină link-urile până când sunt active.
- [ ] REZOLVAT

### BUG-020: Conținut mixt — unele secțiuni nu folosesc i18n JSON [P2]
- **Fișiere**: `HeroInteractive.astro`, `UseCases.astro`, `IntegrationHub.astro`, `BenefitsStrip.astro`
- **Problemă**: Aceste componente au conținut hardcodat inline (obiecte `content` cu RO/EN) în loc să folosească `ro.json`/`en.json`. Editarea conținutului necesită modificare component, nu JSON.
- **Impact**: Inconsistență arhitecturală. Nu este un bug funcțional, dar face editarea conținutului mai dificilă.
- **Fix**: Migra conținutul în fișierele i18n JSON (task mare, low priority).
- [ ] REZOLVAT

### BUG-021: Credențiale în plain text în CLAUDE.md [P1]
- **Fișier**: `CLAUDE.md`
- **Secțiunea**: "Railway All Variables (February 2026)"
- **Problemă**: API key Resend (`re_SSiJmdXw_...`), parola PostgreSQL (`RHiVbAXq...`), și alți credentials sunt în plain text într-un fișier comis în git.
- **Impact**: Oricine cu acces la repository poate vedea credențialele.
- **Fix**: Elimină secțiunea cu credențiale din CLAUDE.md. Credentials trebuie gestionate doar prin Railway dashboard / environment variables.
- [ ] REZOLVAT

---

## CONFLICTE ÎNTRE DOCUMENTE

### BUG-022: Language Switcher active state — contradicție docs [P3]
- **Fișiere**: `docs/branding/BRANDING-NOTES.md` vs `CLAUDE.md`
- **Problemă**: BRANDING-NOTES spune `bg-primary-800` (solid deep slate pill), CLAUDE.md spune `bg-gradient-to-r from-primary-500 to-accent-600` (gradient pill). Trebuie verificat ce este implementat actual și aliniat documentația.
- **Fix**: Verifică `LanguageSwitcher.astro` și actualizează doc-ul incorect.
- [ ] REZOLVAT

### BUG-023: STRATEGY.md — CSS culori vechi cyan/purple [P3]
- **Fișier**: `docs/STRATEGY.md` (Secțiunea 8.2)
- **Problemă**: Exemplul IntegrationHub hover conține `rgba(34, 211, 238, ...)` (cyan vechi) — nu corespunde paletei actuale Deep Slate + Amber.
- **Fix**: Actualizează secțiunea cu culorile curente sau adaugă notă că exemplul e outdated.
- [ ] REZOLVAT

### BUG-024: UX-AUDIT referă ChatSimulator în Hero [P3]
- **Fișier**: `docs/UX-AUDIT-FEBRUARY-2026.md`
- **Problemă**: Menționează ChatSimulator pe mobile la 375px, dar ChatSimulator a fost eliminat din Hero și înlocuit cu VoiceWidget.
- **Fix**: Adaugă notă că auditul a fost făcut pre-VoiceWidget redesign.
- [ ] REZOLVAT

### BUG-025: UX-AUDIT menționează font "Space Grotesk" [P3]
- **Fișier**: `docs/UX-AUDIT-FEBRUARY-2026.md`
- **Problemă**: Referă "Inter + Space Grotesk" dar fontul actual este Inter + Prompt. Space Grotesk nu a fost niciodată folosit.
- **Fix**: Corectează referința la Inter + Prompt.
- [ ] REZOLVAT

### BUG-026: MAINTENANCE.md referă Maven wrapper și Render [P3]
- **Fișier**: `docs/MAINTENANCE.md`
- **Problemă**: Referă `./mvnw` (CLAUDE.md spune să nu se adauge) și "Railway/Render" (Render nu a fost niciodată folosit).
- **Fix**: Actualizează referințele.
- [ ] REZOLVAT

---

## SUMAR

| Prioritate | Count | Categorie |
|-----------|-------|-----------|
| P0 — CRITIC | 1 | Backend sanitize bug |
| P1 — IMPORTANT | 6 | Double escaping, missing files, branding, credentials |
| P2 — MEDIU | 7 | Outdated refs, sitemap, social links, nul file |
| P3 — LOW | 12 | Cleanup, docs conflicts, unused code |
| **TOTAL** | **26** | |

---

*Creat: 12 Februarie 2026*
*Ultima actualizare: 12 Februarie 2026*

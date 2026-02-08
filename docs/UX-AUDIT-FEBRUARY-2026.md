# 🧠 Audit UX/UI & Psihologia Cumpărătorului B2B — Februarie 2026

> **Scop**: Analiză completă a site-ului GENERATIVA din perspectiva psihologiei cumpărătorului B2B în domeniul AI/tech și audit UX/UI desktop + mobile.

---

## PARTEA 1: Psihologia Cumpărătorului B2B în Domeniul AI

### Profilul Cumpărătorului

- **CEO/Owner SME** din România, 35-55 ani
- **Nivel AI**: Știu că există, nu știu cum funcționează
- **Durere principală**: Pierd clienți pentru că nu răspund la telefon
- **Frică ascunsă**: "O să fie prea scump" / "N-o să funcționeze la mine"
- **Motivator**: Eficiență, nu fascinație tehnologică

### Cele 5 Faze ale Deciziei B2B în AI

| Faza | Ce gândește clientul | Ce trebuie să vadă pe site | Status |
|------|---------------------|---------------------------|--------|
| **1. Awareness** | "Am o problemă, dar nu știu dacă AI e soluția" | Demo vizual instant | ✅ Chat Simulator |
| **2. Consideration** | "OK, pare interesant, dar funcționează la mine?" | Industria lui specifică | ✅ UseCases |
| **3. Evaluation** | "Cât costă? Cât durează? Ce risc?" | Cifre concrete + FAQ | ✅ Benefits + FAQ |
| **4. Decision** | "De ce ei, nu altcineva?" | Diferențiere + Social proof | ⚠️ Parțial — lipsește social proof |
| **5. Action** | "Vreau să vorbesc cu cineva" | CTA fără fricțiune | ⚠️ Formular cu 7 câmpuri |

### Ce Face Site-ul BINE (Psihologic)

1. **Demo-First** — Vizitatorii văd AI-ul funcționând în primele 5 secunde. Elimină scepticismul mai repede decât orice text.

2. **Auto-identificare** (UseCases) — Când un dentist vede "Clinică dentară" cu exact problema lui, apare efectul de **validare cognitivă**. Gândește: "Ei mă înțeleg."

3. **Cifre realiste** — "0.8s timp de răspuns", "90% rezolvate automat" (nu "100%!"). Construiește **încredere prin onestitate** — diferențiator major față de competiția care promite "-90% costuri."

4. **Ton uman** — "Vreau și eu așa ceva" ca CTA, nu "Get Started Free". Reduce bariera psihologică.

5. **FAQ ca instrument de conversie** — Răspunde la obiecții ÎNAINTE ca vizitatorul să le pună: "Va înlocui angajații?" → "Nu." Dezamorsează frica principală.

### Ce Lipsește (Psihologic)

| Problemă | Impact | Gravitate |
|----------|--------|-----------|
| **Zero social proof real** | Fără testimoniale, fără logo-uri clienți, fără studii de caz | 🔴 CRITIC |
| **Nu există "de ce noi?" pe homepage** | Vizitatorul nu știe de ce să aleagă GENERATIVA vs Agentic.ro | 🔴 CRITIC |
| **Formularul de contact are 7 câmpuri** | Fiecare câmp suplimentar reduce conversia cu ~10% | 🟡 IMPORTANT |
| **Lipsește urgența** | Niciun element de timp ("primii 10 clienți", "ofertă limitată") | 🟡 IMPORTANT |
| **Prețuri complet absente** | Cumpărătorul B2B vrea cel puțin un "de la X€/lună" | 🟡 IMPORTANT |
| **Pagina Despre nu e linkuită prominent** | Trust-building-ul e ascuns | 🟢 MINOR |

---

## PARTEA 2: Audit UX/UI — Desktop

### Ce Funcționează Excelent

1. **Flow-ul homepage-ului** este aproape textbook perfect:
   ```
   Demo (WOW) → Beneficii (rapid) → Servicii (ce oferim) →
   Use Cases (te recunoști?) → Integrări (cum se leagă) →
   Scale (metrici) → Proces (cum lucrăm) → FAQ → CTA
   ```
   Urmează modelul **AIDA** (Attention → Interest → Desire → Action).

2. **Alternanța light/dark** (stil Stripe) — Creează ritm vizual și previne "scroll fatigue."

3. **Ierarhia tipografică** — Inter + Space Grotesk funcționează bine. Display headings cu letter-spacing negativ dau feel premium.

4. **Brand gradient** (cyan→purple) — Consistent peste tot, memorabil, diferențiator vizual.

5. **Header gradient subtil** — `from-primary-50/80 via-white/80 to-accent-50/60` cu backdrop-blur dă efect de sticlă premium.

### Probleme Desktop

| # | Problemă | Locație | Impact |
|---|----------|---------|--------|
| 1 | **IntegrationHub: linii animate fără context** | Homepage | Utilizatorul nu înțelege ce reprezintă liniile dashed animate. Lipsesc labels "input"/"output" |
| 2 | **ScaleWithConfidence: animație abstractă** | Homepage | Wave-ul arată frumos dar nu comunică nimic concret. Metafora "flux de date" nu e evidentă fără explicație |
| 3 | **Services dropdown în header: hover trigger** | Header | Pe desktop necesită precizie de mouse. Mega-menu sau click trigger ar fi mai sigur |
| 4 | **Niciun element sticky CTA** | Global | Odată ce header-ul CTA iese din view (pe paginile de servicii lungi), nu mai există CTA vizibil |
| 5 | **Spațiul gol pe 3+2 grid** | Service pages | Unele secțiuni au 5 carduri pe grid de 3 coloane — rândul de jos arată incomplet |

---

## PARTEA 3: Audit UX/UI — Mobile

### Ce Funcționează Excelent

1. **Horizontal scroll cu snap** — Pattern-ul `flex md:grid` e implementat consistent. Reduce scroll-ul vertical dramatic.

2. **Dynamic scroll arrows** — Săgețile care apar/dispar bazat pe scroll position sunt un detaliu excelent de UX.

3. **Touch targets** — Butoanele au minimum 44px, conform Apple HIG.

4. **Language switcher** — Toggle pill compact funcționează bine pe mobile + scroll position preservation.

5. **Mobile menu** — Hamburger menu cu CTA full-width la final e pattern corect.

### Probleme Mobile

| # | Problemă | Locație | Impact |
|---|----------|---------|--------|
| 1 | **IntegrationHub labels la 9px** | Homepage | Pe telefoane cu DPI scăzut, textul e efectiv ilizibil. Minimum recomandat e 12px |
| 2 | **Chat Simulator pe mobile** | Hero | Demo-ul care e WOW pe desktop poate fi greu de citit pe 375px. Mesajele din chat pot fi tăiate |
| 3 | **7 câmpuri în formular pe mobile** | Contact | Scroll interminabil pe telefon. Pe mobile, 3-4 câmpuri e maximul recomandat |
| 4 | **Hero stats cards** | Hero | 3 carduri cu counter animation pe un rând pe mobile pot fi crowded |
| 5 | **No swipe hint pe BenefitsStrip** | Homepage | Secțiunea are scroll orizontal dar NU are indicator vizual (spre deosebire de Services/UseCases) |
| 6 | **Canvas wave pe mobile vechi** | ScaleWithConfidence | 35 linii cu animație continuă pot cauza battery drain pe telefoane mai vechi |

---

## PARTEA 4: Recomandări Prioritizate

### 🔴 CRITICE (Impact mare pe conversie)

#### 1. Adaugă Social Proof pe Homepage
- **Minim**: "50+ companii din România folosesc GENERATIVA" cu logo-uri (chiar și placeholder)
- **Ideal**: 2-3 testimoniale reale cu nume, companie, foto
- **De ce**: În B2B, 92% din cumpărători citesc testimoniale înainte de a contacta. Fără social proof, site-ul pare "nou și netestat."
- **Unde**: Între UseCases și IntegrationHub (după auto-identificare, înainte de detalii tehnice)

#### 2. Simplifică Formularul de Contact
- **Varianta actuală**: 7 câmpuri (5 required)
- **Varianta recomandată**: 3 câmpuri (Nume, Email, Mesaj) + CTA "Programează Demo"
- Industry/Interest se pot colecta în follow-up call
- **De ce**: Fiecare câmp suplimentar reduce conversia cu ~10%. Un formular de 7 câmpuri poate avea conversion rate cu 50-60% mai mic decât unul de 3.

#### 3. Adaugă Indicii de Preț
- Nu trebuie prețuri exacte. Un simplu "De la 500€/lună" sau "Investiție tipică: 2.000-10.000€" ajută enorm.
- **De ce**: Cumpărătorii B2B care nu găsesc informații despre preț presupun că e "prea scump" și pleacă. 60% din cumpărătorii B2B consideră prețul cel mai important factor.

### 🟡 IMPORTANTE (Îmbunătățesc experiența)

#### 4. Sticky CTA pe Paginile de Servicii
- Un buton fix "Solicită Demo" care apare după scroll 50% pe paginile de servicii
- **De ce**: Pe paginile lungi (servicii, despre), CTA-ul din header dispare, iar cel de la final e departe

#### 5. Adaugă Secțiune "De Ce Noi?" pe Homepage
- 3-4 diferențiatori față de competiție: demo live, fără contract pe termen lung, echipă locală, suport în română
- **Unde**: Între Process și FAQ
- **De ce**: Vizitatorul care ajunge la FAQ e aproape convins — are nevoie de ultima confirmare că a ales corect

#### 6. Adaugă Label-uri Contextuale pe IntegrationHub
- Categorii vizuale: "Canale de intrare" (stânga), "Sisteme" (dreapta)
- Annotation pe linii: "date sincronizate"
- **De ce**: Vizualizarea e frumoasă dar abstractă — utilizatorii non-tehnici nu înțeleg ce văd

#### 7. Optimizează BenefitsStrip pe Mobile
- Adaugă swipe hint (existent pe UseCases/Services, lipsește aici)
- Sau: transformă în grid 2x3 pe mobile (fiecare benefit e mic oricum)

### 🟢 NICE-TO-HAVE (Rafinamente)

#### 8. Calendar Booking Direct
- Integrare Calendly/Cal.com pe pagina de contact ca alternativă la formular
- **De ce**: Unii cumpărători B2B preferă să-și aleagă singuri slot-ul

#### 9. Exit-Intent Popup
- Când user-ul mișcă mouse-ul spre tab-ul browserului, arată popup cu ofertă simplificată: "Hai să vorbim 15 minute. Gratuit."
- Doar pe desktop, doar la prima vizită

#### 10. Animație Wave cu Context
- Adaugă labels sub canvas: "Volume mari de cereri" (stânga) → "GENERATIVA" (centru) → "Răspunsuri consistente" (dreapta)
- **De ce**: Transformă decorația în comunicare

---

## SCOR FINAL

| Aspect | Scor | Comentariu |
|--------|------|-----------|
| **Structura paginii** | 9/10 | Flow-ul AIDA e aproape perfect |
| **Design vizual** | 8.5/10 | Premium, consistent, branded |
| **Copy/Messaging** | 7.5/10 | Bun dar lipsește social proof și pricing |
| **UX Desktop** | 8/10 | Solid, câteva secțiuni abstracte |
| **UX Mobile** | 7.5/10 | Horizontal scroll e smart, dar formular și labels au probleme |
| **Conversion Path** | 6.5/10 | Formularul lung + lipsa social proof = fricțiune mare |
| **Psihologie Buyer** | 7/10 | Bun pe awareness/consideration, slab pe decision/action |
| **SEO/AEO** | 9/10 | Question-based H2, Schema.org, FAQ — excelent |

**Scor Global: 7.9/10** — Site solid cu fundație excelentă, dar cu 2-3 lipsuri critice care pot afecta semnificativ rata de conversie (social proof, pricing hints, formular simplificat).

---

## Analiza Structurii per Pagină

### Homepage — Flow Conversie

```
1. HeroInteractive     → WOW factor (Chat Simulator)     ✅ Excelent
2. BenefitsStrip       → Impact rapid (6 beneficii)       ✅ Bun
3. Services            → Ce oferim (3 servicii)           ✅ Bun
4. UseCases            → Auto-identificare (6 industrii)  ✅ Excelent
5. IntegrationHub      → Vizualizare conexiuni            ⚠️ Abstract fără labels
6. ScaleWithConfidence → Metrici + animație wave          ⚠️ Wave decorativ
7. Process             → Cum funcționăm (4 pași)          ✅ Clar
8. FAQ                 → Obiecții rezolvate               ✅ Excelent
9. CTA                 → Contact final                    ⚠️ Lipsește social proof înainte
```

### Pagini Servicii — Pattern Comun

```
Hero (Light) → Content Cards (White) → Approach/Timeline (Dark) →
Benefits/Metrics (Light) → FAQ Accordion (White) → CTA (Dark)
```
- ✅ Alternanța light/dark e consistentă
- ✅ Question-based H2 pe toate secțiunile
- ✅ FAQ-urile targetează People Also Ask
- ⚠️ Lipsește social proof pe fiecare pagină de serviciu

### Pagina Despre — Trust Building

```
Hero → Story → Mission (Dark) → Approach → Why Us → Stats (Dark) → CTA
```
- ✅ Storytelling compelling
- ✅ Stats cu animație counter
- ⚠️ Nu e linkuită prominent din homepage

---

*Audit realizat: Februarie 2026*
*Următorul pas: Analiza rezultatelor și prioritizare implementări*

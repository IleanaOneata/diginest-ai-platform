# Psihologia Conversiei — Research & Implementare

> **Pentru AI**: Acest document conține TOATE research-urile de psihologie CRO (Conversion Rate Optimization) aplicate pe site-ul GENERATIVA. Folosește-l ca referință pentru orice decizie legată de copy, CTA, layout sau UX.

---

## Status: ✅ Implementat + Extins pe Service Pages (Februarie 2026)
- Commits: `41045b4` (conversion optimization), `a837ecb` (social proof), `440517d` (service pages CRO)
- Branch: `staging`

---

## 1. Principii Psihologice Aplicate

### 1.1 Loss Aversion (Aversiunea față de pierdere)

**Sursa**: Daniel Kahneman & Amos Tversky — Prospect Theory (1979)

**Principiu**: Pierderile sunt resimțite de **2x mai puternic** decât câștigurile echivalente. Un client pierdut doare de 2 ori mai mult decât un client câștigat bucură.

**Cum am aplicat**:

| Element | Înainte (gain-framed) | După (loss-framed) |
|---------|----------------------|-------------------|
| Hero headline | "Agenți AI care răspund clienților tăi 24/7" | **"Niciun client pierdut. Niciun apel ratat."** |
| Hero CTA | "Programează o analiză gratuită" | **"Vezi ce pierzi acum"** |
| CTA section title | "Află în 30 min ce poți automatiza" | **"Câți clienți ai pierdut săptămâna asta?"** |
| UseCases CTA | "Vreau și eu așa ceva" | **"Începe evaluarea"** |

**Extensie pe paginile de servicii** (13 Februarie 2026):

| Pagină | CTA Title (Loss-framed) |
|--------|------------------------|
| ProcessAutomation | **"Câte ore pierde echipa ta pe sarcini repetitive?"** |
| ConversationalAgents | **"Câți clienți ai pierdut săptămâna asta din cauza apelurilor nepreluate?"** |
| AiIntegrations | **"Câte ore pierde echipa ta copiind date între sisteme?"** |

Fiecare pagină de serviciu are acum un CTA loss-framed SPECIFIC pentru problema pe care o rezolvă acel serviciu. Nu e generic — vizitatorul simte pierderea relevantă pentru el.

**De ce funcționează pe publicul nostru**:
- CEO/Owner SME simte direct impactul financiar al clienților pierduți
- "Ratat" e un cuvânt cu impact emoțional puternic — activează **regret aversion**
- Double loss frame: "pierdut" + "ratat" în aceeași propoziție = impact amplificat

### 1.2 Endowment Effect (Efectul de proprietate)

**Sursa**: Richard Thaler — "Toward a Positive Theory of Consumer Choice" (1980)

**Principiu**: Oamenii valorizează mai mult lucrurile pe care le consideră "ale lor". Dacă simți că deja ai ceva, nu vrei să-l pierzi.

**Cum am aplicat**:

| Element | Înainte | După |
|---------|---------|------|
| VoiceWidget CTA | "Vorbește cu agentul AI" | **"Vorbește cu asistentul tău"** |
| Demo form submit | "Programează analiza gratuită" | **"Vreau evaluarea mea gratuită"** |

**De ce funcționează**:
- "Asistentul **tău**" — vizitatorul simte că deja îi aparține, chiar înainte de achiziție
- "Evaluarea **mea**" — prima persoană creează ownership psihologic
- Reduce rezistența la acțiune — nu cumperi ceva nou, ci accesezi ceva ce deja e al tău

### 1.3 First-Person CTA Effect

**Sursa**: ContentVerve A/B test (Michael Aagaard, 2012), replicat de Unbounce, HubSpot

**Date**: CTA-urile la persoana I ("Vreau X", "Trimite-mi X") au **+90% CTR** față de persoana a II-a ("Obține X", "Primești X") sau a III-a ("Start Free Trial").

**Cum am aplicat**:

| Element | Înainte | După |
|---------|---------|------|
| Demo form submit | "Programează analiza gratuită" | **"Vreau evaluarea mea gratuită"** |
| CTA principal | "Programează o analiză gratuită" | **"Începe acum"** |
| Hero CTA | "Programează analiză" | **"Vezi ce pierzi acum"** |
| Service pages CTA | "Evaluare gratuită" | **"Vreau evaluarea mea gratuită"** |
| Mid-page CTA | (nu exista) | **"Vreau evaluarea mea gratuită"** |

**Extensie pe service pages** (13 Februarie 2026): Toate 3 paginile de servicii + mid-page CTAs folosesc acum "Vreau evaluarea mea gratuită" (first-person) în loc de "Evaluare gratuită" (impersonal). Consistent pe 6+ puncte de contact.

### 1.4 Sensory Curiosity (Curiozitate senzorială)

**Principiu**: Formulări care invocă simțuri concrete (auz, văz) activează curiozitatea naturală și reduc bariera de acțiune.

**Cum am aplicat**:

| Element | Înainte | După |
|---------|---------|------|
| VoiceWidget hint | "Încearcă demo-ul vocal AI" | **"Demo live · Ascultă cum sună"** |
| VoiceWidget badge | "Apasă pentru demo AI" | **"Încearcă demo-ul vocal"** |

**De ce funcționează**:
- "Ascultă cum sună" = curiozitate auditivă — creierul vrea să satisfacă curiozitatea
- "Demo live" = implicația că e real, nu simulat
- Eliminarea "AI" din text = reduce anxietatea la publicul non-tehnic

### 1.5 Von Restorff Effect (Isolation Effect)

**Sursa**: Hedwig von Restorff (1933)

**Principiu**: Un element care se distinge de restul este reținut mai bine. În design, o singură culoare de accent (amber) pe fundal neutru (slate) face CTA-ul imposibil de ignorat.

**Aplicare design**: Amber (#F59E0B) pe Deep Slate (#1E293B) — singura culoare vibrantă din paletă. Toate CTA-urile au aceeași culoare, creând asociere consistentă: amber = acțiune.

---

## 2. Decizii de Copy — Rationamente

### 2.1 Alegerea "ratat" vs "nerespondat"

**Context**: Prima versiune a headline-ului era "Niciun client pierdut. Niciun apel nerespondat." — dar "nerespondat" nu e un cuvânt uzual în limba română.

**Alternative evaluate**:

| Cuvânt | Psihologie | Impact emoțional | Decizie |
|--------|-----------|-------------------|---------|
| nerespondat | Neutru, descriptiv | Slab — sună tehnic/administrativ | ❌ Respins |
| neprimit | Ambiguu (cine nu a primit?) | Confuz | ❌ Respins |
| pierdut | Loss aversion | Puternic — dar ar repeta "pierdut" din prima parte | ❌ Repetitiv |
| **ratat** | **Regret aversion** — implică oportunitate irosită | **Foarte puternic** — activează și FOMO | ✅ **ALES** |
| ignorat | Frustrare, neglijență | Puternic dar negativ — sugerează vină | ❌ Prea agresiv |

**Rațional final**: "ratat" creează un **double loss frame** cu "pierdut" — două pierderi diferite (client pierdut = pierdere relațională, apel ratat = pierdere de oportunitate) care amplifică urgența fără a fi agresiv.

### 2.2 Eliminarea jargonului "AI"

**Cercetare**: Gartner 2025 — 67% din decision-makerii B2B sunt sceptici față de promisiunile AI. Cuvântul "AI" poate activa:
- Scepticism ("încă un buzzword")
- Anxietate ("o să ne ia joburile")
- Defență ("nu e pentru noi, suntem prea mici")

**Decizie**: Înlocuim "AI" cu limbaj uman oriunde interfața e customer-facing:

| Înainte | După | Rațional |
|---------|------|----------|
| Agentul AI | Asistentul tău | Ownership + familiar |
| Demo vocal AI | Demo live | Focus pe experiență, nu tehnologie |
| Agenți AI inteligenți | Asistenți virtuali | Mai puțin intimidant |

**Excepție**: Pe paginile de servicii (audience mai informată), "AI" rămâne în titluri și conținut tehnic unde e relevant.

### 2.3 Unificarea CTA → "Evaluare gratuită"

**Problema**: Site-ul avea 5 CTA-uri diferite pe diferite pagini:
- "Consultanță gratuită"
- "Solicită o demonstrație"
- "Programează un audit tehnic"
- "Hai să discutăm"
- "Evaluare gratuită"

**Research**: Nielsen Norman Group — CTA consistency across pages reduces cognitive load și crește conversion. Vizitatorii nu trebuie să proceseze un mesaj nou la fiecare punct de contact.

**Decizie**: **"Evaluare gratuită"** pe toate paginile de servicii + About
- "Evaluare" = non-committal (nu "contract", nu "programare")
- "Gratuită" = eliminare barieră preț
- Consistent pe 7 CTA-uri (3 service pages hero+cta, About)

### 2.4 Diferențierea Demo vs Contact

**Problema**: Ambele formulare aveau copy identic ("Programează o analiză gratuită") → vizitatorii nu înțelegeau diferența.

**Decizie**:

| Formular | Scop | Titlu | Submit CTA | Câmpuri |
|----------|------|-------|------------|---------|
| **Demo** (`/demo/`) | Lead qualification, evaluare business | "Spune-ne despre afacerea ta" | "Vreau evaluarea mea gratuită" | Industry, Problem, GDPR, etc. |
| **Contact** (`/contact/`) | Întrebări generale, mesaje directe | "Contactează-ne" | "Trimite mesajul" | Nume, Email, Mesaj |

---

## 3. Flow de Conversie — Homepage

### Flow-ul Psihologic

```
1. Hero          → PIERDERE: "Niciun client pierdut" (loss aversion)
                  → ACȚIUNE: "Vezi ce pierzi acum" (urgență)
                  → DEMO VOCAL: "Ascultă cum sună" (curiozitate senzorială)

2. BenefitsStrip → VIZIUNE: Ce primești (gain frame, complementar)

3. TrustBar      → CREDIBILITATE: Logos parteneri tech + badges security
                  → REDUCERE RISC: "Pilot gratuit 14 zile"

4. Services      → SOLUȚII: Ce oferim (CTA: "Evaluare gratuită")

5. UseCases      → IDENTIFICARE: "Ți se pare familiar?"
                  → AUTO-SELECȚIE: Vizitatorul își găsește industria

6. IntegrationHub → COMPETENȚĂ: "Ce se întâmplă în spate"

7. Process       → CLARITATE: 4 pași simpli (reduce anxietate)

8. ScaleWithConfidence → DOVEZI: Metrici business

9. FAQ           → OBIECȚII: Răspunsuri preemptive (neutralizează frica)

10. CTA          → CONVERSIE FINALĂ: "Câți clienți ai pierdut?" (loss aversion)
                  → REDUCERE RISC: "Pilot gratuit 14 zile, fără card"
                  → TRUST: "Fără obligații · 30 minute · Răspuns în 24h"
```

### Elementul cheie: Alternarea Loss Frame → Gain Frame

Homepage-ul alternează între **pierdere** (motivator) și **câștig** (viziune):

```
Hero (PIERDERE) → Benefits (CÂȘTIG) → TrustBar (ÎNCREDERE) →
Services (SOLUȚIE) → UseCases (IDENTIFICARE) → IntegrationHub (COMPETENȚĂ) →
Process (CLARITATE) → Scale (DOVEZI) → FAQ (OBIECȚII) → CTA (PIERDERE + REZOLVARE)
```

Această alternanță menține tensiunea emoțională fără a fi copleșitoare.

### Flow Psihologic — Pagini de Servicii (13 Februarie 2026)

```
1. Hero            → SOLUȚIE: Headline descriptiv + CTA "Evaluare gratuită"
2. TrustBar Mini   → CREDIBILITATE: Tech logos relevante + badges (GDPR, SSL, EU, Pilot)
3. Content Cards   → DETALII: Ce facem concret (capabilities/process types/systems)
4. Approach        → CLARITATE: Cum funcționează (timeline, pași)
5. Industries      → IDENTIFICARE: Vizitatorul își găsește industria cu problem→solution
6. Mid-page CTA    → CONVERSIE INTERMEDIARĂ: "Recunoști aceste probleme?" + first-person button
7. Benefits        → DOVEZI: Metrici concrete (%, ore, cost)
8. FAQ             → OBIECȚII: Răspunsuri la "Cât costă?", "Înlocuiesc angajații?", etc.
9. CTA             → CONVERSIE FINALĂ: Loss-framed title + pilot + trust checkmarks
```

**Principiu cheie**: Mid-page CTA vine IMEDIAT după Industries — momentul în care vizitatorul tocmai s-a identificat cu o problemă și e cel mai motivat să acționeze. Trust indicators (checkmarks + pilot offer) reduc fricțiunea pe CTA final.

---

## 4. Metrici de Conversie — Așteptări & Benchmark-uri

### Benchmark-uri B2B SaaS Landing Pages

| Metrică | Media industriei | Target GENERATIVA | Notă |
|---------|-----------------|-------------------|------|
| Conversion Rate (visitor → lead) | 2-5% | 5-8% | Demo-first approach + loss frame |
| Bounce Rate | 40-60% | <45% | Hero compelling + demo instant |
| Time on Page | 45-90s | >120s | Voice widget + scroll pattern |
| CTA Click Rate | 2-5% | 5-10% | Loss aversion CTAs + amber contrast |
| Form Completion Rate | 30-50% | >50% | Formular simplificat + risk reversal |

### Optimizări Recomandate pentru Viitor

1. **A/B Testing** — Testează headline actual ("Niciun client pierdut") vs alternative gain-framed
2. **Heatmap** — Hotjar/Microsoft Clarity pentru a vedea unde se opresc vizitatorii
3. **Form Analytics** — Care câmp abandonează lumea (probabil Industry dropdown)
4. **Scroll Depth** — Câți ajung la CTA-ul de jos?
5. **Voice Widget Engagement** — Câți pornesc demo-ul vocal?

---

## 5. Research Neaplicat Încă — Oportunități

### 5.1 Pricing Anchoring

**Principiu**: Dacă arăți un preț de referință, oamenii evaluează oferta relativ la acel preț.

**Recomandare**: Adaugă "De la 200€/lună" undeva pe pagină — chiar dacă nu e prețul exact, ancorează așteptările și elimină frica "o să fie 10.000€".

**Status**: ❌ Neimplementat — necesită decizie business

### 5.2 Scarcity/Urgency

**Principiu**: FOMO (Fear of Missing Out) accelerează decizia.

**Recomandare**: "Acceptăm doar 5 clienți noi pe lună" sau "Locuri limitate pentru pilot gratuit"

**Status**: ❌ Neimplementat — poate fi perceput ca fake dacă e un business nou

### 5.3 Social Proof Real (Testimoniale)

**Principiu**: 92% din cumpărătorii B2B citesc testimoniale înainte de contact (G2 Research).

**Plan**: După primele pilot-uri gratuite → solicită testimoniale video scurte (30s)

**Status**: ❌ Neimplementat — necesită clienți reali. Vezi `docs/SOCIAL-PROOF-STRATEGY.md` pentru strategia interim

### 5.4 Exit-Intent Popup

**Principiu**: Oferă o alternativă low-commitment când vizitatorul vrea să plece.

**Recomandare**: "Hai să vorbim 15 minute. Gratuit. Fără obligații." — formular cu doar email.

**Status**: ❌ Neimplementat — recomandat ca nice-to-have

---

## 6. Referințe & Surse

| Sursă | Ce am extras |
|-------|-------------|
| Kahneman & Tversky (1979) — Prospect Theory | Loss aversion 2x |
| Thaler (1980) — Endowment Effect | "Asistentul tău" ownership |
| ContentVerve/Unbounce A/B tests | First-person CTA +90% CTR |
| HubSpot (50k+ landing pages) | Amber CTA +32-40% click rate |
| Nielsen Norman Group | CTA consistency, flat > gradient buttons |
| Von Restorff (1933) — Isolation Effect | Single accent color (amber) |
| Gartner 2025 | 67% B2B scepticism față de AI promises |
| Baymard Institute | Flat buttons > gradient buttons pe CTA |
| G2 Research | 92% B2B citesc testimoniale |
| comScore | Partner logos +43% conversions |

---

*Creat: 12 Februarie 2026*
*Actualizat: 13 Februarie 2026 (service pages CRO — loss-framed CTAs, mid-page CTAs, TrustBar Mini)*
*Commits: `41045b4`, `a837ecb`, `440517d` (staging)*

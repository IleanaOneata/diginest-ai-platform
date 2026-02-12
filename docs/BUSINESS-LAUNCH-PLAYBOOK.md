# GENERATIVA — Business Launch Playbook

> **Pentru AI**: Acest document conține TOATE direcțiile strategice, planurile de lansare, și deciziile de business pentru GENERATIVA. Citește-l complet înainte de orice task legat de strategie, marketing, pricing sau creștere.

---

## Status: Pre-Lansare (Februarie 2026)
- Site: 95% ready pe staging
- Backend: Funcțional (Railway + PostgreSQL + Resend emails)
- Domeniu: generativa.ro (DNS configurat, site pe Vercel staging)

---

## 1. Rezumat Executiv

### Ce este GENERATIVA
O agenție care oferă **asistenți virtuali** (voice + chat + email) pentru automatizarea comunicării cu clienții. Target: SME-uri din România cu volum mare de apeluri/mesaje.

### Propunere de Valoare Core
> "Nu vindem tehnologie. Oferim liniște sufletească — știi că fiecare client primește răspuns, fiecare oportunitate e capturată, 24/7, fără să angajezi mai mulți oameni."

### Model de Business
- **Serviciu recurent** (SaaS-like) — configurare + mentenanță lunară
- **Revenue streams**: Setup fee + abonament lunar + customizări adiționale
- **Diferențiator**: Demo-first approach (vizitatorii aud/văd AI-ul funcționând în 5 secunde)

---

## 2. Analiza Pieței România

### Maturitatea Pieței AI în România (2026)

| Aspect | Status |
|--------|--------|
| Awareness AI generativ | Ridicat (ChatGPT, Gemini = mainstream) |
| Adopție AI în SME-uri | Foarte scăzut (<5% au implementat ceva) |
| Competiție directă | Emergentă (2-3 jucători, niciunul dominant) |
| Bariera principală | "Nu e pentru noi" / "E prea scump" / "Nu funcționează în română" |
| Oportunitate | Piață "greenfield" — cine captează încrederea acum, câștigă |

### Competiție Directă

| Competitor | URL | Diferențiere GENERATIVA |
|------------|-----|------------------------|
| **Agentic.ro** | agentic.ro | Noi: demo live, ton uman, design warm. Ei: dark agresiv, promisiuni bold (-90%) |
| **Inflate.agency** | inflate.agency | Noi: multicanal (voice+chat+email), localizat RO. Ei: focus doar voice, less localized |
| **Agenți internaționali** | Various | Noi: suport în română, echipă locală, GDPR EU. Ei: English-first, no RO support |

### De Ce Vom Câștiga

1. **Demo-First** — Nimeni din RO nu arată AI-ul funcționând instant
2. **Limba română nativă** — Voice AI care sună natural în română (nu tradus din EN)
3. **Verticalizare** — Ne focusăm pe 6 industrii specifice, nu "AI for everyone"
4. **Onestitate** — Cifre realiste (90%, nu 100%), pilot gratuit real
5. **Relație locală** — Echipă în România, suport în română, înțelegem business-ul local

---

## 3. Publicul Țintă — Detalii Complete

### Persona Primară: "Maria" — Owner Clinică Dentară

| Atribut | Detalii |
|---------|---------|
| **Vârstă** | 35-50 ani |
| **Rol** | Owner sau manager clinică/cabinet |
| **Echipă** | 5-15 angajați |
| **Tech savviness** | Mediu — folosește smartphone, nu e expert IT |
| **Durere #1** | "Pierdem pacienți pentru că nu răspundem la telefon după program" |
| **Durere #2** | "Recepția e copleșită cu apeluri repetitive, face erori" |
| **Frică** | "AI o să sune ca un robot și o să sperie pacienții" |
| **Motivație** | Eficiență operațională, nu fascinație tech |
| **Buget** | €200-500/lună pentru soluții care chiar funcționează |
| **Cum decide** | Vrea să VADĂ/AUDĂ cum funcționează înainte de a plăti |
| **Timp de decizie** | 2-4 săptămâni (dacă demo-ul impresionează) |

### Cele 6 Industrii Prioritare

| # | Industrie | Durere specifică | Volum apeluri | Oportunitate |
|---|-----------|-----------------|---------------|-------------|
| 1 | **Clinici dentare** | Programări pierdute, no-show | 30-80/zi | 🔴 Mare |
| 2 | **Cabinete medicale** | Apeluri în afara programului | 20-50/zi | 🔴 Mare |
| 3 | **Saloane beauty/SPA** | No-show 30-40%, reminder-e manuale | 15-40/zi | 🟡 Medie-Mare |
| 4 | **Service-uri auto** | "Când e gata mașina?" x50/zi | 20-60/zi | 🟡 Medie |
| 5 | **Restaurante cu rezervări** | Rezervări pierdute seara/weekend | 10-30/zi | 🟡 Medie |
| 6 | **Rețele multi-locații** | Experiență inconsistentă între locații | Variabil | 🔴 Mare (contract mare) |

### Decision Makers (cine semnează)

| Mărime companie | Decident | Ce-l convinge |
|-----------------|----------|---------------|
| 1-10 angajați | CEO/Owner direct | Demo live, ROI clar, preț accesibil |
| 10-50 angajați | Office Manager + CEO | Demo + testimonial din industria lor |
| 50+ angajați | CTO/Head of Ops | Integrări, scalabilitate, SLA |

---

## 4. Strategie de Pricing

### Principii

1. **Nu afișăm prețuri pe site** — Strategia e demo-first → discuție → preț personalizat
2. **Pricing-ul se discută în call** — După ce clientul a văzut demo-ul și a înțeles valoarea
3. **Pilot gratuit 14 zile** — Reduce bariera de intrare la zero
4. **Upsell natural** — Start simplu (1 canal), adaugă canale/integrări progresiv

### Structura de Pricing (internă)

| Plan | Target | Preț orientativ | Ce include |
|------|--------|-----------------|-----------|
| **Starter** | 1 locație, 1 canal | €200-400/lună | Voice SAU chat, 1 integrare, suport email |
| **Business** | Multi-canal sau multi-locație | €500-1.000/lună | Voice + chat + email, 3-5 integrări, suport prioritar |
| **Enterprise** | Rețele mari, custom | €1.000-3.000/lună | Tot, SLA, manager dedicat, integrări custom |

### Setup Fee

| Complexitate | Fee | Include |
|-------------|-----|---------|
| Simplu (1 canal, template) | €500-1.000 | Configurare, training model, testing |
| Mediu (multi-canal) | €1.000-2.500 | + Integrări CRM/Calendar |
| Complex (custom flows) | €2.500-5.000 | + Flows personalizate, API custom |

### Pricing Hint pe Site (RECOMANDAT — Neimplementat)

**Recomandare UX Audit**: Adaugă "De la 200€/lună" undeva vizibil.

**Rațional**: 60% din cumpărătorii B2B care nu găsesc indicii de preț presupun "e prea scump" și pleacă.

**Opțiuni**:
1. **Pe homepage (FAQ)**: "Care este investiția?" → "Planurile noastre pornesc de la 200€/lună, în funcție de complexitate."
2. **Pe pagina de servicii**: Badge subtil "De la 200€/lună"
3. **Pe formularul demo**: "Investiție tipică: 200-1.000€/lună"

---

## 5. Planul de Lansare

### Faza 0: Pre-lansare (ACUM)

| Task | Status | Detalii |
|------|--------|---------|
| Site complet pe staging | ✅ 95% | Copy optimizat, social proof, CRO |
| Backend funcțional | ✅ | Emails, DB, API |
| Domeniu generativa.ro | ✅ DNS | Trebuie configurat pe Vercel |
| Review final vizual | ⏳ | Verificare pe preview URL |
| Merge staging → main | ⏳ | După review final |

### Faza 1: Soft Launch (Săptămânile 1-2)

| Task | Scop |
|------|------|
| **Publicare site pe domeniu final** | generativa.ro live |
| **Setup analytics** | Plausible sau Umami (privacy-first, GDPR compliant) |
| **Google Search Console** | Submit sitemap, monitorizare indexare |
| **Google Business Profile** | Creare profil cu adresa DIGITAL LEADERSHIP SRL |
| **10 piloturi gratuite** | Identificare 10 business-uri din industriile target, oferire pilot |
| **Rețea personală** | Contactare directă — dentist, doctor, salon pe care-i cunoști |

### Faza 2: Traction (Lunile 1-3)

| Task | Scop |
|------|------|
| **Colectare testimoniale** | Video scurte de la participanții pilot |
| **Primele case studies** | 2-3 studii de caz cu metrici reale |
| **Content marketing** | 2 articole/lună pe blog (când îl lansăm) |
| **LinkedIn presence** | Postări regulate cu insights din piloturi |
| **Parteneriate** | Colaborare cu furnizori software stomatologic (DentPlus, etc.) |
| **Referral program** | Oferă 1 lună gratuită pentru fiecare client recomandat |

### Faza 3: Scale (Lunile 3-6)

| Task | Scop |
|------|------|
| **Google Ads** | Campanii pe keywords RO (cost: €500-1.000/lună) |
| **Facebook/Instagram Ads** | Targetare owners clinici/saloane (cost: €300-500/lună) |
| **Secțiune Studii de Caz pe site** | Pagină dedicată cu toate case studies |
| **Pricing pe site** | Când avem suficiente date de preț, afișăm plans |
| **Blog SEO** | Articole targetând long-tail keywords |
| **Events** | Participare la conferințe business/tech RO |

### Faza 4: Expansion (6+ luni)

| Task | Scop |
|------|------|
| **Extindere industrii** | Imobiliare, juridic, educație |
| **Piața de EN** | Target expats, multinationale din RO |
| **White-label** | Oferire soluție white-label pentru agenții marketing |
| **Marketplace integrări** | Plugin-uri pre-built pentru CRM-uri populare |

---

## 6. KPI-uri și Obiective

### Obiective la Lansare (Luna 1)

| KPI | Target | Cum măsurăm |
|-----|--------|-------------|
| **Vizite site** | 500+ vizitatori unici | Analytics |
| **Lead-uri** (form submissions) | 20+ | Database backend |
| **Conversion rate** | 4-5% | Lead-uri / Vizitatori |
| **Demo voice clicks** | 50+ | Event tracking |
| **Piloturi active** | 5-10 | Manual tracking |

### Obiective la 3 Luni

| KPI | Target |
|-----|--------|
| **Vizite site** | 2.000+/lună |
| **Lead-uri** | 40+/lună |
| **Clienți plătitori** | 5-10 |
| **MRR (Monthly Recurring Revenue)** | €1.500-3.000 |
| **Testimoniale reale** | 3-5 video |
| **Case studies** | 2-3 publicate |

### Obiective la 6 Luni

| KPI | Target |
|-----|--------|
| **Vizite site** | 5.000+/lună |
| **Lead-uri** | 80+/lună |
| **Clienți plătitori** | 20-30 |
| **MRR** | €5.000-10.000 |
| **Google rankings** | Top 5 pentru "asistent virtual AI România" |
| **Churn rate** | <10% |

---

## 7. Canale de Achiziție — Strategie

### Canal 1: Organic Search (SEO) — Cost: €0, Time: 3-6 luni

**Status**: Fundație excelentă (Schema.org, question-based H2, FAQ, hreflang)

**Keywords targetate**:
| Keyword | Volume estimat | Dificultate |
|---------|---------------|-------------|
| asistent virtual AI România | Low-Med | Low |
| automatizare apeluri telefonice | Low | Low |
| chatbot clinic dentară | Very Low | Very Low |
| AI customer service Romania | Low | Low-Med |
| răspuns automat telefon business | Low | Low |

**Avantaj**: Piață "greenfield" — competiție SEO aproape inexistentă pe aceste keywords în RO.

### Canal 2: LinkedIn Organic — Cost: €0, Time: Ongoing

**Strategie**: Postări de la fondatoare cu insights reale din implementări
- Behind-the-scenes din piloturi
- Numere reale (nu promisiuni)
- Storytelling: "Ce a pățit o clinică dentară când a pierdut 20 apeluri într-o zi"
- Target: CEO/Owners din industriile noastre

**Frecvență**: 2-3 postări/săptămână

### Canal 3: Referral Network — Cost: €0, Time: Ongoing

**Strategie**: Fiecare pilot reușit → cerere testimonial + cerere referral
- Oferă 1 lună gratuită per referral convertit
- Dentistul X recomandă dentistului Y → relație de încredere transferată

### Canal 4: Direct Outreach — Cost: €0, Time: Immediate

**Strategie**: Contactare directă 50-100 business-uri din industriile target
- Mesaj personalizat pe WhatsApp Business / email
- "Am construit un asistent care răspunde pacienților la telefon 24/7. Ți-l configurăm gratuit 14 zile."
- Focus: Cluj, București, Timișoara (orașe cu SME-uri tech-friendly)

### Canal 5: Google Ads — Cost: €500-1.000/lună, Time: Luna 2-3

**Când**: După ce avem 2-3 testimoniale reale (ads fără social proof = money burn)

**Campanii**:
1. **Brand protection**: "generativa" (cost: minimal)
2. **Problem-aware**: "nu răspund la telefon", "pierd clienți" (cost: mediu)
3. **Solution-aware**: "chatbot business", "AI răspuns telefonic" (cost: mediu-mare)

### Canal 6: Parteneriate — Cost: €0, Time: Luna 2-3

**Target parteneri**:
- Furnizori software stomatologic (DentPlus, Dentis, D4W)
- Furnizori software medical (MedTech, Hipocrat)
- Agenții web care servesc clinici/saloane
- Contabili/consultanți business care au clienți SME

**Model**: Comision 10-15% per client referit SAU white-label

---

## 8. Riscuri și Mitigare

| Risc | Probabilitate | Impact | Mitigare |
|------|--------------|--------|----------|
| VAPI/API pricing crește | Medie | Mare | Diversificare providers, negociere volum |
| Calitate voice AI în română scade | Scăzut | Mare | Testing continuu, fallback la modele alternative |
| Competiție agresivă (pricing war) | Medie | Mediu | Focus pe serviciu + relație, nu pe preț |
| Clienți nu reînnoiesc | Medie | Mare | Onboarding excelent, QBR-uri (quarterly business reviews) |
| GDPR compliance issues | Scăzut | Foarte Mare | DPA-uri cu toți providerii, date procesate doar în UE |
| Pierdere developer key person | Medie | Mare | Documentare completă (aceste docs!), cod clean |

---

## 9. Infrastructura Necesară la Lansare

### Checklist Pre-Lansare

| # | Task | Status | Prioritate |
|---|------|--------|-----------|
| 1 | Site live pe generativa.ro | ⏳ | 🔴 CRITIC |
| 2 | SSL certificate (Let's Encrypt via Vercel) | ✅ Auto | - |
| 3 | Email funcțional (contact@generativa.ro) | ✅ | - |
| 4 | Google Search Console | ⏳ | 🔴 CRITIC |
| 5 | Google Analytics / Plausible | ⏳ | 🔴 CRITIC |
| 6 | Google Business Profile | ⏳ | 🟡 IMPORTANT |
| 7 | LinkedIn company page | ⏳ | 🟡 IMPORTANT |
| 8 | Facebook business page | ⏳ | 🟢 NICE-TO-HAVE |
| 9 | CRM simplu (HubSpot Free) | ⏳ | 🟡 IMPORTANT |
| 10 | Contracte/Terms (juridic) | ✅ | - |
| 11 | DPA cu VAPI, Resend, Vercel | ⏳ | 🟡 IMPORTANT |
| 12 | Backup database automat | ⏳ | 🟡 IMPORTANT |

---

## 10. Informații Companie

### Date Legale
| Atribut | Valoare |
|---------|---------|
| **Nume companie** | DIGITAL LEADERSHIP SRL |
| **CUI** | 38585123 |
| **Reg. Comerț** | J12/6715/2017 |
| **Sediu** | Dezmir, Cluj |
| **Brand** | GENERATIVA |
| **Domeniu** | generativa.ro |

### Stack Tehnic
| Component | Tehnologie | Cost |
|-----------|-----------|------|
| Frontend | Astro + Tailwind + Vercel | Free tier |
| Backend | Spring Boot + Railway | ~$5/lună |
| Database | PostgreSQL (Supabase) | Free tier |
| Emails | Resend.com | Free tier (3k/lună) |
| Voice AI | VAPI | Pay per minute |
| DNS | Cloudflare / cPanel | Inclus în hosting |

---

## 11. Lecții Învățate (Din Proces)

### Design & UX
1. **Loss-framed headlines convertesc mai bine** decât gain-framed pentru B2B
2. **Amber pe slate** = combinația de culori cu cel mai mare contrast CTA
3. **"Evaluare gratuită"** e mai accesibil decât "audit", "consultanță", sau "demo"
4. **Pilot gratuit 14 zile** > orice altceva pentru a depăși bariera "dacă nu funcționează?"
5. **Un singur CTA per ecran** > multiple opțiuni (paradoxul alegerii)
6. **Flat CTA buttons** > gradient buttons (Baymard Institute data)

### Tech
1. **Railway blochează SMTP** — folosește doar HTTP APIs (Resend)
2. **`railway up` CLI nu funcționează** cu monorepo-uri — doar GitHub auto-deploy
3. **Astro `define:vars`** nu e compatibil cu `import()` dinamic — folosește `is:inline`
4. **SVG inline > PNG** pentru logo-uri — scalabilitate, performance, editabilitate

### Business
1. **Demo-first** e cel mai puternic diferențiator — nimeni din România oferă asta
2. **B2B buyers sunt sceptici** față de AI — ton uman și onestitate câștigă încredere
3. **Social proof fără clienți** e posibil cu borrowed credibility (tech logos) + risk reversal (pilot gratuit)
4. **"Nu vindem AI"** — vindem liniște sufletească, timp liber, apeluri nepierdute

---

*Creat: 12 Februarie 2026*
*Ultima actualizare: 12 Februarie 2026*
*Documente conexe: STRATEGY.md, CONVERSION-PSYCHOLOGY.md, SOCIAL-PROOF-STRATEGY.md*

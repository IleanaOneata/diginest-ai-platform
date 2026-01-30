# Ghid de Mentenanță și Evoluție - Diginest AI Platform

## 📋 Cuprins

1. [Mentenanță Curentă](#mentenanță-curentă)
2. [Actualizarea Conținutului](#actualizarea-conținutului)
3. [Securitate](#securitate)
4. [Performanță](#performanță)
5. [Monitorizare](#monitorizare)
6. [Backup & Recovery](#backup--recovery)
7. [Roadmap Tehnic](#roadmap-tehnic)

---

## 🔧 Mentenanță Curentă

### Actualizări Săptămânale

```bash
# Frontend - verifică și actualizează dependențele
cd frontend
npm outdated
npm update

# Backend - verifică dependențele
cd backend
./mvnw versions:display-dependency-updates
```

### Actualizări Lunare

1. **Security patches** - Rulează `npm audit` și `mvn dependency-check:check`
2. **Dependency updates** - Actualizează versiuni minore
3. **Content review** - Verifică textele și link-urile

### Actualizări Trimestriale

1. **Major version updates** - Astro, Spring Boot
2. **Performance audit** - Lighthouse, Core Web Vitals
3. **SEO audit** - Verifică rankings și indexare
4. **UX review** - Analizează comportamentul utilizatorilor

---

## 📝 Actualizarea Conținutului

### Modificarea Textelor

Textele sunt în fișierele de traduceri:

```
frontend/src/i18n/locales/ro.json  # Română
frontend/src/i18n/locales/en.json  # Engleză
```

**Exemplu de modificare:**

```json
// Schimbă tagline-ul
{
  "site": {
    "tagline": "Noul tagline aici"
  }
}
```

### Adăugarea unui Articol de Blog

1. Creează fișierul în `frontend/src/content/blog/ro/`:

```markdown
---
title: "Titlul articolului"
description: "Descriere scurtă pentru SEO"
pubDate: 2025-02-01
author: "Nume Autor"
tags: ["AI", "automatizare"]
---

Conținutul articolului aici...
```

2. Build și deploy automat via GitHub Actions

### Adăugarea unui Case Study

Similar cu blog-ul, în `frontend/src/content/case-studies/ro/`

---

## 🔒 Securitate

### Checklist Lunar

- [ ] Verifică `npm audit` pentru vulnerabilități
- [ ] Verifică `mvn dependency-check:check` pentru backend
- [ ] Review logs pentru activitate suspectă
- [ ] Verifică certificatul SSL (expirare)
- [ ] Testează rate limiting

### Practici Obligatorii

1. **Nu stoca secrete în cod** - Folosește environment variables
2. **Actualizează dependențele** - Mai ales security patches
3. **Review CORS settings** - Doar domeniile necesare
4. **Monitorizează rate limits** - Ajustează dacă e nevoie

### În Caz de Incident

1. Verifică logs în Railway/Render dashboard
2. Analizează traffic-ul în analytics
3. Blochează IP-uri suspecte (dacă e cazul)
4. Documentează incidentul

---

## ⚡ Performanță

### Targets Core Web Vitals

| Metric | Target | Tool |
|--------|--------|------|
| LCP | < 2.5s | Lighthouse |
| FID | < 100ms | Lighthouse |
| CLS | < 0.1 | Lighthouse |
| TTFB | < 600ms | WebPageTest |

### Optimizări Frontend

```bash
# Analizează bundle size
cd frontend
npm run build -- --analyze

# Verifică imagini neoptimizate
# Folosește WebP format, lazy loading
```

### Optimizări Backend

```java
// Monitorizează query-urile lente
// În application-prod.yml:
logging:
  level:
    org.hibernate.stat: DEBUG
```

---

## 📊 Monitorizare

### Metrici de Urmărit

**Business:**
- Număr de lead-uri / lună
- Conversion rate (vizitatori → lead)
- Bounce rate
- Time on site

**Tehnice:**
- Uptime (target: 99.9%)
- Response time API (target: < 200ms)
- Error rate (target: < 0.1%)

### Tools Recomandate

1. **Plausible/Umami** - Analytics (privacy-friendly)
2. **Railway/Render Metrics** - Backend monitoring
3. **Vercel Analytics** - Frontend performance
4. **Better Uptime** - Uptime monitoring (free tier)

### Alerte

Configurează alerte pentru:
- Uptime sub 99%
- Error rate peste 1%
- Response time peste 500ms
- Lead-uri = 0 într-o zi lucrătoare

---

## 💾 Backup & Recovery

### Backup Automat

**Database (PostgreSQL via Supabase/Railway):**
- Backup automat zilnic
- Retenție: 7 zile (free tier)

**Cod:**
- Git repository pe GitHub
- Multiple branches pentru safety

### Recovery Procedure

1. **Frontend down:**
   - Vercel re-deploy automat din main
   - Manual: `vercel --prod` din local

2. **Backend down:**
   - Railway auto-restart
   - Manual: redeploy din dashboard

3. **Database corruption:**
   - Restore din backup
   - Contact Supabase/Railway support

---

## 🗺️ Roadmap Tehnic

### Faza 2: Backend Enhancement (Lună 2-3)

- [ ] Integrare completă contact form cu API
- [ ] Newsletter subscription
- [ ] Admin dashboard simplu pentru leads
- [ ] Email templates HTML

### Faza 3: AI Demo (Lună 3-4)

- [ ] Chat widget cu OpenAI/Claude
- [ ] Demo scenarii predefinite
- [ ] Rate limiting per utilizator
- [ ] Analytics pentru demo usage

### Faza 4: Scale (Lună 5+)

- [ ] Blog CMS (poate Decap CMS)
- [ ] Multi-language content auto-generate
- [ ] A/B testing pentru CTA
- [ ] Advanced analytics

### Considerații pentru Scalare

1. **CDN caching** - Deja prin Vercel/Cloudflare
2. **Database scaling** - Upgrade Supabase plan când e necesar
3. **API rate limiting** - Ajustare pe baza traficului
4. **Image optimization** - Consider Cloudinary pentru multe imagini

---

## 📞 Suport și Resurse

### Documentație

- [Astro Docs](https://docs.astro.build)
- [Spring Boot Docs](https://docs.spring.io/spring-boot)
- [Tailwind CSS](https://tailwindcss.com/docs)

### Comunitate

- Astro Discord
- Spring Community Forums
- Stack Overflow

### Contacte Interne

- **Technical Lead**: [email]
- **DevOps**: [email]
- **Design**: [email]

---

*Ultima actualizare: Ianuarie 2025*

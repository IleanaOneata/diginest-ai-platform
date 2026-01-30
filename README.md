# Diginest AI - AI Agents Platform

Platform for Diginest AI - an AI Agents agency website with lead generation capabilities.

## 🏗️ Architecture

```
ai-agents-platform/
├── frontend/          # Astro + Tailwind (Static site)
├── backend/           # Spring Boot API (Java 21)
├── docs/              # Documentation
└── .github/           # CI/CD workflows
```

## 🚀 Quick Start

### Prerequisites

- **Node.js 20+** (for frontend)
- **Java 21** (for backend)
- **Git**

### Frontend Development

```bash
cd frontend
npm install
npm run dev
```

Site available at `http://localhost:4321`

### Backend Development

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

API available at `http://localhost:8080`

## 📦 Tech Stack

### Frontend
- **Astro 4.x** - Static site generator
- **Tailwind CSS 3.x** - Styling
- **TypeScript** - Type safety
- **i18n** - Romanian & English

### Backend
- **Java 21** - Runtime
- **Spring Boot 3.2** - Framework
- **Spring Security** - Security
- **PostgreSQL** - Database (production)
- **H2** - Database (development)

## 🔒 Environment Variables

### Frontend (Vercel)
```
SITE_URL=https://diginest.ai
```

### Backend (Railway/Render)
```
DATABASE_URL=postgresql://...
DATABASE_USERNAME=...
DATABASE_PASSWORD=...
MAIL_HOST=smtp.resend.com
MAIL_USERNAME=resend
MAIL_PASSWORD=re_...
EMAIL_ENABLED=true
EMAIL_FROM=noreply@diginest.ai
EMAIL_ADMIN=contact@diginest.ai
CORS_ORIGINS=https://diginest.ai
```

## 🚢 Deployment

### Frontend → Vercel
1. Connect repo to Vercel
2. Set root directory: `frontend`
3. Build command: `npm run build`
4. Output directory: `dist`

### Backend → Railway
1. Connect repo to Railway
2. Set root directory: `backend`
3. Add PostgreSQL addon
4. Set environment variables

## 📝 License

Proprietary - Diginest / Digital Leadership

## 🤝 Contributing

Internal use only. Contact team lead for contribution guidelines.

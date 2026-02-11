/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}'],
  theme: {
    extend: {
      // Brand Colors — GENERATIVA Option D (Deep Slate + Warm Amber)
      // Research-backed: Stripe depth + warm CTA (Von Restorff effect)
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
          500: '#F59E0B', // Brand amber
          600: '#D97706',
          700: '#B45309',
          800: '#92400E',
          900: '#78350F',
          950: '#451A03',
        },
        // Neutral — cool slate tones
        neutral: {
          50: '#F8FAFC',  // Cloud white
          100: '#F1F5F9',
          200: '#E2E8F0',
          300: '#CBD5E1',
          400: '#94A3B8',
          500: '#64748B',
          600: '#475569', // Text secondary
          700: '#334155',
          750: '#263244', // Headings
          800: '#1E293B',
          900: '#0F172A', // Text primary
          950: '#020617', // Deepest
        },
        // Brand reference
        brand: {
          slate: '#1E293B',
          amber: '#F59E0B',
          dark: '#0F172A',
          light: '#F8FAFC',
        },
        // Border
        border: {
          DEFAULT: '#E2E8F0',
        },
      },

      // Typography — Inter for UI, Prompt only for logo
      fontFamily: {
        sans: ['Inter', 'system-ui', '-apple-system', 'sans-serif'],
        brand: ['Prompt', 'system-ui', 'sans-serif'],
        mono: ['JetBrains Mono', 'monospace'],
      },

      // Font sizes with refined hierarchy
      fontSize: {
        'display-lg': ['3.75rem', { lineHeight: '1.1', letterSpacing: '-0.01em', fontWeight: '700' }],
        'display': ['3rem', { lineHeight: '1.12', letterSpacing: '-0.005em', fontWeight: '700' }],
        'heading-lg': ['2.25rem', { lineHeight: '1.2', letterSpacing: '-0.005em', fontWeight: '600' }],
        'heading': ['1.875rem', { lineHeight: '1.25', fontWeight: '600' }],
        'heading-sm': ['1.5rem', { lineHeight: '1.3', fontWeight: '600' }],
        'body-lg': ['1.125rem', { lineHeight: '1.6', fontWeight: '400' }],
        'body': ['1rem', { lineHeight: '1.6', fontWeight: '400' }],
        'body-sm': ['0.875rem', { lineHeight: '1.5', fontWeight: '400' }],
      },

      // Spacing — 8px grid system
      spacing: {
        '18': '4.5rem',   // 72
        '22': '5.5rem',   // 88
        '30': '7.5rem',   // 120
      },

      // Border radius — standardized tokens
      borderRadius: {
        'sm': '8px',
        'md': '12px',
        'lg': '16px',
        'pill': '999px',
        '4xl': '2rem',
      },

      // Box shadows — single refined system
      boxShadow: {
        'soft': '0px 10px 30px rgba(0, 0, 0, 0.08)',
        'medium': '0px 10px 30px rgba(0, 0, 0, 0.08)',
        'highlight': '0 0 0 3px rgba(30, 41, 59, 0.3)',
        'highlight-amber': '0 0 0 3px rgba(245, 158, 11, 0.4)',
      },

      // Background gradients — Option D (Slate + Amber)
      backgroundImage: {
        'gradient-brand': 'linear-gradient(135deg, #1E293B 0%, #334155 50%, #0F172A 100%)',
        'gradient-brand-reverse': 'linear-gradient(135deg, #0F172A 0%, #334155 50%, #1E293B 100%)',
        'gradient-hero': 'linear-gradient(to bottom right, #F8FAFC, #ffffff, #FFFBEB)',
        'gradient-dark': 'radial-gradient(ellipse at top, #1E293B 0%, #0F172A 50%, #020617 100%)',
      },

      // Animations
      animation: {
        'fade-in': 'fadeIn 0.5s ease-out',
        'slide-up': 'slideUp 0.5s ease-out',
        'slide-down': 'slideDown 0.3s ease-out',
        'pulse-slow': 'pulse 3s cubic-bezier(0.4, 0, 0.6, 1) infinite',
      },
      keyframes: {
        fadeIn: {
          '0%': { opacity: '0' },
          '100%': { opacity: '1' },
        },
        slideUp: {
          '0%': { opacity: '0', transform: 'translateY(20px)' },
          '100%': { opacity: '1', transform: 'translateY(0)' },
        },
        slideDown: {
          '0%': { opacity: '0', transform: 'translateY(-10px)' },
          '100%': { opacity: '1', transform: 'translateY(0)' },
        },
      },

      // Container
      container: {
        center: true,
        padding: {
          DEFAULT: '1rem',
          sm: '2rem',
          lg: '4rem',
          xl: '5rem',
        },
      },
    },
  },
  plugins: [],
};

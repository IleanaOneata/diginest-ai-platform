/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}'],
  theme: {
    extend: {
      // Brand Colors — GENERATIVA (Refined)
      colors: {
        // Primary Brand Gradient anchors
        primary: {
          50: '#ecfeff',
          100: '#cffafe',
          200: '#a5f3fc',
          300: '#67e8f9',
          400: '#22d3ee',
          500: '#16B6C9', // Brand cyan
          600: '#0891b2',
          700: '#0e7490',
          800: '#155e75',
          900: '#164e63',
          950: '#083344',
        },
        accent: {
          50: '#faf5ff',
          100: '#f3e8ff',
          200: '#e9d5ff',
          300: '#d8b4fe',
          400: '#c084fc',
          500: '#a855f7',
          600: '#7C3AED', // Brand violet
          700: '#6d28d9',
          800: '#5b21b6',
          900: '#4c1d95',
          950: '#3b0764',
        },
        // Neutral system — disciplined
        neutral: {
          50: '#F7F8FA',  // Primary light
          100: '#f1f5f9',
          200: '#e2e8f0',
          300: '#cbd5e1',
          400: '#94a3b8',
          500: '#64748b',
          600: '#475569', // Text secondary
          700: '#334155',
          750: '#263244', // Headings — 5% lighter than 800
          800: '#1e293b',
          900: '#0F172A', // Text primary
          950: '#0B0F1A', // Primary dark
        },
        // Brand gradient reference
        brand: {
          cyan: '#16B6C9',
          blue: '#4F7CF3',
          violet: '#7C3AED',
          dark: '#0B0F1A',
          light: '#F7F8FA',
        },
        // Border neutral
        border: {
          DEFAULT: '#E5E7EB',
        },
      },

      // Typography — Prompt is the official brand font
      fontFamily: {
        sans: ['Prompt', 'system-ui', '-apple-system', 'sans-serif'],
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
        'highlight': '0 0 0 3px rgba(22, 182, 201, 0.4)',
        'highlight-purple': '0 0 0 3px rgba(124, 58, 237, 0.4)',
      },

      // Background gradients
      backgroundImage: {
        'gradient-brand': 'linear-gradient(90deg, #16B6C9 0%, #4F7CF3 50%, #7C3AED 100%)',
        'gradient-brand-reverse': 'linear-gradient(90deg, #7C3AED 0%, #4F7CF3 50%, #16B6C9 100%)',
        'gradient-hero': 'linear-gradient(to bottom right, #F7F8FA, #ffffff, #faf5ff)',
        'gradient-dark': 'radial-gradient(ellipse at top, #111827 0%, #0B0F1A 50%, #1E1B4B 100%)',
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

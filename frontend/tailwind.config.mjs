/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}'],
  theme: {
    extend: {
      // Brand Colors - GENERATIVA (Rebranded)
      colors: {
        // Primary - Cyan vibrant (tehnologie, inovație)
        primary: {
          50: '#ecfeff',
          100: '#cffafe',
          200: '#a5f3fc',
          300: '#67e8f9',
          400: '#22d3ee', // Main cyan din logo
          500: '#06b6d4',
          600: '#0891b2', // Hover
          700: '#0e7490',
          800: '#155e75',
          900: '#164e63',
          950: '#083344',
        },
        // Accent - Purple electric (creativitate, AI)
        accent: {
          50: '#faf5ff',
          100: '#f3e8ff',
          200: '#e9d5ff',
          300: '#d8b4fe',
          400: '#c084fc',
          500: '#a855f7',
          600: '#8b5cf6', // Main purple din logo
          700: '#7c3aed',
          800: '#6d28d9',
          900: '#5b21b6',
          950: '#3b0764',
        },
        // Neutral - Warm dark tones (profesionalism)
        neutral: {
          50: '#fafafa', // Light background din logo
          100: '#f4f4f5',
          200: '#e4e4e7',
          300: '#d4d4d8',
          400: '#a1a1aa',
          500: '#71717a',
          600: '#52525b',
          700: '#3f3f46',
          800: '#27272a',
          900: '#18181b', // Dark background din logo
          950: '#09090b',
        },
        // Brand gradient colors (pentru referință)
        brand: {
          cyan: '#22d3ee',
          purple: '#8b5cf6',
          dark: '#18181b',
          light: '#fafafa',
        },
      },

      // Typography
      fontFamily: {
        sans: ['Inter', 'system-ui', '-apple-system', 'sans-serif'],
        mono: ['JetBrains Mono', 'monospace'],
        // Font pentru logo text (geometric bold)
        display: ['Space Grotesk', 'Inter', 'system-ui', 'sans-serif'],
      },

      // Custom font sizes with line heights
      fontSize: {
        'display-lg': ['3.75rem', { lineHeight: '1.1', letterSpacing: '-0.02em' }],
        'display': ['3rem', { lineHeight: '1.15', letterSpacing: '-0.02em' }],
        'heading-lg': ['2.25rem', { lineHeight: '1.2', letterSpacing: '-0.01em' }],
        'heading': ['1.875rem', { lineHeight: '1.25' }],
        'heading-sm': ['1.5rem', { lineHeight: '1.3' }],
        'body-lg': ['1.125rem', { lineHeight: '1.6' }],
        'body': ['1rem', { lineHeight: '1.6' }],
        'body-sm': ['0.875rem', { lineHeight: '1.5' }],
      },

      // Spacing
      spacing: {
        '18': '4.5rem',
        '22': '5.5rem',
        '30': '7.5rem',
      },

      // Border radius
      borderRadius: {
        '4xl': '2rem',
      },

      // Box shadows
      boxShadow: {
        'soft': '0 2px 15px -3px rgba(0, 0, 0, 0.07), 0 10px 20px -2px rgba(0, 0, 0, 0.04)',
        'medium': '0 4px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04)',
        'highlight': '0 0 0 3px rgba(34, 211, 238, 0.5)', // Cyan highlight
        'highlight-purple': '0 0 0 3px rgba(139, 92, 246, 0.5)', // Purple highlight
      },

      // Background gradients
      backgroundImage: {
        'gradient-brand': 'linear-gradient(135deg, #22d3ee 0%, #8b5cf6 100%)',
        'gradient-brand-reverse': 'linear-gradient(135deg, #8b5cf6 0%, #22d3ee 100%)',
        'gradient-hero': 'linear-gradient(to bottom right, #ecfeff, #ffffff, #faf5ff)',
        'gradient-dark': 'linear-gradient(135deg, #18181b 0%, #27272a 100%)',
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

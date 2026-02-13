import { defineConfig } from 'astro/config';
import tailwind from '@astrojs/tailwind';
import sitemap from '@astrojs/sitemap';

// https://astro.build/config
export default defineConfig({
  site: 'https://generativa.ro',

  // Default language and i18n configuration
  i18n: {
    defaultLocale: 'ro',
    locales: ['ro', 'en'],
    routing: {
      prefixDefaultLocale: true, // /ro/ and /en/ prefixes
    },
  },

  integrations: [
    tailwind(),
    sitemap(),
  ],

  // Build configuration
  build: {
    // Generate clean URLs without .html extension
    format: 'directory',
  },

  // Development server
  server: {
    port: 3000,
    host: true,
  },

  // Vite configuration
  vite: {
    build: {
      cssMinify: true,
    },
  },
});

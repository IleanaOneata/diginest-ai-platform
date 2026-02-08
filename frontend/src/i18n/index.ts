/**
 * Internationalization utilities for Diginest AI
 *
 * This module provides type-safe translation functions and language utilities.
 * Supports: Romanian (ro) and English (en)
 */

import ro from './locales/ro.json';
import en from './locales/en.json';

// Supported locales
export const locales = ['ro', 'en'] as const;
export type Locale = (typeof locales)[number];

// Default locale
export const defaultLocale: Locale = 'ro';

// Translation dictionaries
const translations = { ro, en } as const;

/**
 * Get translations for a specific locale
 */
export function getTranslations(locale: Locale) {
  return translations[locale] || translations[defaultLocale];
}

/**
 * Get a specific translation by key path
 * @example t('nav.services', 'ro') // returns "Servicii"
 */
export function t(key: string, locale: Locale): string {
  const dict = getTranslations(locale);
  const keys = key.split('.');
  let result: unknown = dict;

  for (const k of keys) {
    if (result && typeof result === 'object' && k in result) {
      result = (result as Record<string, unknown>)[k];
    } else {
      console.warn(`Translation key not found: ${key}`);
      return key;
    }
  }

  return typeof result === 'string' ? result : key;
}

/**
 * Get the alternate locale
 */
export function getAlternateLocale(locale: Locale): Locale {
  return locale === 'ro' ? 'en' : 'ro';
}

/**
 * Get locale from URL path
 */
export function getLocaleFromPath(path: string): Locale {
  const segments = path.split('/').filter(Boolean);
  const firstSegment = segments[0] as Locale;

  if (locales.includes(firstSegment)) {
    return firstSegment;
  }

  return defaultLocale;
}

/**
 * Build a path for a specific locale
 */
export function buildLocalePath(path: string, locale: Locale): string {
  // Remove existing locale prefix if present
  const cleanPath = path.replace(/^\/(ro|en)/, '');
  return `/${locale}${cleanPath || '/'}`;
}

/**
 * Language display names
 */
export const languageNames: Record<Locale, string> = {
  ro: 'Română',
  en: 'English',
};

/**
 * Language flags (emoji)
 */
export const languageFlags: Record<Locale, string> = {
  ro: '🇷🇴',
  en: '🇬🇧',
};

/**
 * Get HTML lang attribute value
 */
export function getHtmlLang(locale: Locale): string {
  return locale === 'ro' ? 'ro-RO' : 'en-US';
}

/**
 * Format date according to locale
 */
export function formatDate(date: Date, locale: Locale): string {
  return new Intl.DateTimeFormat(locale === 'ro' ? 'ro-RO' : 'en-US', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  }).format(date);
}

/**
 * Path mappings between locales
 * Maps RO paths to EN paths and vice versa
 */
const pathMappings: Record<string, Record<Locale, string>> = {
  // About page
  'despre': { ro: 'despre', en: 'about' },
  'about': { ro: 'despre', en: 'about' },
  // Contact page
  'contact': { ro: 'contact', en: 'contact' },
  // Services pages
  'servicii': { ro: 'servicii', en: 'services' },
  'services': { ro: 'servicii', en: 'services' },
  // Service sub-pages
  'automatizare-procese': { ro: 'automatizare-procese', en: 'process-automation' },
  'process-automation': { ro: 'automatizare-procese', en: 'process-automation' },
  'agenti-conversationali': { ro: 'agenti-conversationali', en: 'conversational-agents' },
  'conversational-agents': { ro: 'agenti-conversationali', en: 'conversational-agents' },
  'integrari-ai': { ro: 'integrari-ai', en: 'ai-integrations' },
  'ai-integrations': { ro: 'integrari-ai', en: 'ai-integrations' },
  // Legal pages
  'politica-confidentialitate': { ro: 'politica-confidentialitate', en: 'privacy-policy' },
  'privacy-policy': { ro: 'politica-confidentialitate', en: 'privacy-policy' },
  'termeni-conditii': { ro: 'termeni-conditii', en: 'terms-conditions' },
  'terms-conditions': { ro: 'termeni-conditii', en: 'terms-conditions' },
  // Blog
  'blog': { ro: 'blog', en: 'blog' },
  // Add more mappings as needed
};

/**
 * Translate a path segment from one locale to another
 */
function translatePathSegment(segment: string, targetLocale: Locale): string {
  const mapping = pathMappings[segment.toLowerCase()];
  if (mapping) {
    return mapping[targetLocale];
  }
  return segment; // Return original if no mapping found
}

/**
 * Build alternate language path
 * Handles translation of path segments between locales
 * e.g., /en/about/ -> /ro/despre/
 */
export function buildAlternatePath(currentPath: string, currentLocale: Locale, targetLocale: Locale): string {
  // Split path into segments
  const segments = currentPath.split('/').filter(Boolean);

  // If path is just the locale (homepage), return target locale homepage
  if (segments.length === 0 || (segments.length === 1 && locales.includes(segments[0] as Locale))) {
    return `/${targetLocale}/`;
  }

  // Remove current locale prefix if present
  const pathSegments = segments[0] === currentLocale ? segments.slice(1) : segments;

  // Translate each segment
  const translatedSegments = pathSegments.map(segment => translatePathSegment(segment, targetLocale));

  // Build final path
  return `/${targetLocale}/${translatedSegments.join('/')}/`.replace(/\/+/g, '/');
}

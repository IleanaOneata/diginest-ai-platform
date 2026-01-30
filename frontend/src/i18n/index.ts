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

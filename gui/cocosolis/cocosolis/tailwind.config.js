/** @type {import('tailwindcss').Config} */
export default {
  purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        'primary-foreground': '#ffffff',       
        'primary-background': '#664164',
        'primary-accent': '#f0d8ca',
        'secondary-foreground': '#f0dfd6',       
        'secondary-background': '#816c65',      
        'secondary-accent': '#daa48a',         
      },
      fontFamily: {
        sans: ["Inter", 'Helvetica', 'Arial', 'sans-serif'], 
      },
      spacing: {
        '18': '4.5rem',
        '22': '5.5rem',
      },
      fontSize: {
        'xs': '0.75rem',
        'sm': '0.875rem',
        'base': '1rem',
        'lg': '1.125rem',
        'xl': '1.25rem',
        '2xl': '1.5rem',
        '3xl': '1.875rem',
        '4xl': '2.25rem',
      },
      borderRadius: {
        'lg': '12px', // Larger rounded corners
      },
      boxShadow: {
        'button': '0 4px 6px rgba(0, 0, 0, 0.1)', // Subtle shadow for buttons
      },
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}


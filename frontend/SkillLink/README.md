# AlumniThon


## Estructura de carpeta

```
SkillLink/
├── public/              # Archivos estáticos (favicon, imágenes públicas)
├── src/                 # Código fuente del proyecto
│   ├── assets/          # 🎨 Imágenes, íconos SVG, fuentes, logos
│   │   ├── icons/
│   │   └── images/
│   ├── components/      # 🧩 Componentes organizados
│   │   ├── common/      # Header, Footer, Layouts simples
│   │   ├── features/    # Componentes por funcionalidad/dominio
│   │   ├── layouts/     # Layouts principales (DashboardLayout, AuthLayout)
│   │   ├── modals/      # Modales centralizados
│   │   └── ui/          # Componentes atómicos y reutilizables (Button, Input)
│   ├── context/         # 🧠 Context API providers
│   ├── hooks/           # 🪝 Custom hooks reutilizables
│   ├── lib/             # 🧰 Helpers, funciones utilitarias
│   ├── pages/           # 🧭 Rutas React Router
│   ├── services/        # 🌐 API clients, llamadas a endpoints
│   ├── types/           # 📐 Tipos globales TypeScript
│   ├── App.tsx
│   ├── main.tsx
│   ├── styles.css
│   └── vite-env.d.ts
├── .gitignore
├── eslint.config.js
├── index.html
├── package.json
├── package-lock.json
├── README.md
├── tsconfig.json        # Configuración TypeScript
├── tsconfig.app.json
├── tsconfig.node.json
└── vite.config.ts
```

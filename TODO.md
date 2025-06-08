# ✅ TODO – JWT Auth API Project (Spring Boot)

## 🎯 Objectif
Créer une API sécurisée par JWT, avec inscription, connexion, rôles (`STUDENT`, `TEACHER`, `ADMIN`), et endpoints protégés. Utilisable dans n’importe quelle future plateforme (cours, dashboard, etc).

---

## 🛠️ Phase 1 – Setup du projet (Jour 1)

- [ ] Créer un projet Spring Boot (via Spring Initializr)
    - Spring Web
    - Spring Security
    - Spring Data JPA
    - H2 Database (ou PostgreSQL)
    - Lombok
- [ ] Créer une structure de packages : `controller`, `service`, `dto`, `model`, `repository`, `security`

---

## 🔐 Phase 2 – Authentification de base (Jour 2-3)

- [ ] Créer les entités : `User`, `Role`
    - `id`, `username`, `email`, `password`, `roles`
- [ ] Créer un `UserRepository`
- [ ] Créer un service `AuthService` avec :
    - [ ] `register()`
    - [ ] `login()`
- [ ] Hasher les mots de passe avec `BCryptPasswordEncoder`

---

## 🔑 Phase 3 – JWT (Jour 3-4)

- [ ] Créer une classe `JwtUtil` :
    - [ ] Génération de JWT
    - [ ] Validation + extraction des claims
- [ ] Créer un `JwtFilter` (filtre de sécurité)
- [ ] Configurer `SecurityConfig` :
    - [ ] Autoriser `/login` et `/register`
    - [ ] Protéger toutes les autres routes
    - [ ] Ajouter `AuthenticationManager`

---

## 🧪 Phase 4 – Test des endpoints (Jour 5)

- [ ] `POST /register` – créer un utilisateur
- [ ] `POST /login` – renvoie un JWT
- [ ] `GET /profile` – besoin d’un JWT valide
- [ ] `GET /admin/users` – besoin d’un rôle `ADMIN`
- [ ] Ajouter `@PreAuthorize` ou `hasRole(...)`

---

## 📚 Phase 5 – Swagger + README (Jour 6)

- [ ] Ajouter Springdoc OpenAPI
- [ ] Documenter toutes les routes dans Swagger UI
- [ ] Écrire un bon `README.md` :
    - [ ] Présentation du projet
    - [ ] Comment lancer le backend
    - [ ] Exemples de requêtes (avec JWT)
    - [ ] Infos sur les rôles

---

## 🌟 Bonus (facultatif)

- [ ] Ajouter un système de refresh token
- [ ] Créer des tests unitaires
- [ ] Ajouter Docker (Dockerfile + docker-compose)
- [ ] Créer une interface web simple (React, Thymeleaf ou JS)

---

## 🧼 Finition

- [ ] Nettoyer le code
- [ ] Ajouter des logs utiles
- [ ] Publier le code sur GitHub
- [ ] Partager le lien sur LinkedIn 💼


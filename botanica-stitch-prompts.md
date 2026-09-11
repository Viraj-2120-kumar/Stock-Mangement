# Botanica — Google Stitch Prompt Pack (Website)

## How to work in Stitch (read this once before you start)

Stitch works best when you **don't dump the whole site into one prompt**. The reliable workflow:

1. **Foundation prompt** — describe the site, the theme, and the first page together. This sets Stitch's internal "design memory" (colors, type, spacing, mood).
2. **Lock the theme** — after the first page looks right, tell Stitch to keep that exact style for everything after. This is the single biggest thing that prevents each new page from looking like a different site.
3. **One page per prompt after that** — never ask for two pages in one message. Generate, look at it, refine with a short follow-up ("increase spacing", "make the hero image larger") *before* moving to the next page.
4. **Reuse components by name** — once Stitch has generated a component (e.g. "the plant card from the Shop page"), refer back to it by that name in later prompts instead of re-describing it, so cards/buttons/nav stay consistent.
5. **New chat/project = new site.** Keep all 7 user stories inside **one Stitch project/thread** so the theme persists.
6. Since this is a **website**, describe desktop-width layouts (top navigation bar, wide hero sections, multi-column grids, a footer) — not mobile tab bars or thumb-reach patterns. Mention "responsive, desktop-first" where relevant.

Start Stitch in **Text Prompt mode**.

---

## Project setup prompt (send this first, before anything else)

```
I'm designing "Botanica," a website for discovering and purchasing indoor and outdoor plants. Over this session I'll ask you to generate a full set of connected desktop web pages for it — homepage, login/signup, shop/category browsing, search results, product detail, cart, checkout, order confirmation, account dashboard, and order history. Please keep a single consistent design system across all of them: soft sage green (#4A7C59) as the primary color, warm terracotta (#C77B4D) as the accent color, a warm off-white background (#F7F5F0), rounded corners (16px), soft drop shadows, generous whitespace, and a clean modern sans-serif (Inter/Poppins style). The mood should feel calm, organic, and boutique-nursery — not clinical or corporate. These are desktop web pages, responsive, with a persistent top navigation bar and footer. Confirm you'll hold this style, then wait for my first page request.
```

---

## User Story 1 — Discover Plants on the Homepage
*As a visitor, I want an inviting homepage so I understand what Botanica offers and can start browsing.*

**Page 1: Homepage**
```
Generate the Botanica Homepage (desktop web layout). Top navigation bar: logo on the left, nav links in the center ("Shop", "Indoor", "Outdoor", "Care Guides", "About"), and a search icon, wishlist icon, cart icon, and account icon on the right. Below the nav: a large full-width hero section with a soft gradient or plant photography background, a bold headline "Bring nature home," supporting subtext, and a terracotta "Shop Now" button. Below the hero: a row of category cards ("Indoor", "Outdoor", "Succulents", "Flowering", "Pots & Planters") each with an image and label. Below that: a "Featured Picks" section as a 4-column grid of plant cards (photo, name, price, wishlist heart icon). Below that: a "New Arrivals" section, same card style, 4-column grid. Footer with columns for "Shop", "Company", "Support", a newsletter signup input, and social icons.
```

---

## User Story 2 — Account Access
*As a visitor, I want to sign up or log in so my cart and orders are saved to my account.*

**Page 2: Login**
```
Generate the Login page, keeping the established Botanica style. Centered card layout on the page: left half is a large plant photograph, right half is the login form on the off-white background — logomark at top, headline "Welcome back," email and password input fields with rounded borders, a terracotta "Log In" button, a "Forgot password?" link, a divider with "or continue with", Google/Apple sign-in buttons, and a bottom link "Don't have an account? Sign Up." Keep the top navigation bar minimal here (logo only, centered).
```

**Page 3: Sign Up**
```
Generate the Sign Up page, matching the Login page's split-layout and style exactly (same photo panel, same form styling). Fields for Full Name, Email, Password, Confirm Password, a terms checkbox, and a sage green "Create Account" button. Bottom link: "Already have an account? Log In."
```

---

## User Story 3 — Shop / Browse by Category
*As a visitor, I want to browse plants with filters so I can find what fits my space.*

**Page 4: Shop Page**
```
Generate the Shop page for browsing all plants. Full top navigation bar as on the Homepage. Below it, a page title "Shop All Plants" with a result count. Layout: a left sidebar (roughly 25% width) with filter groups — Category (checkboxes: Indoor, Outdoor, Succulents, Flowering), Light Requirement (Low, Medium, Bright), Price Range (slider), Size (Small, Medium, Large), Pet-Friendly (toggle). Main area (75% width): a sort dropdown top-right ("Sort by: Popularity"), then a 3-column grid of plant cards (same card style as Homepage) with pagination at the bottom.
```

---

## User Story 4 — Search
*As a visitor, I want to search for plants so I can quickly find something specific.*

**Page 5: Search Results**
```
Generate the Search Results page, shown after a user searches "snake plant." Top navigation bar with the search input expanded and active, showing the query. Below it, a "Showing results for 'snake plant'" heading with a result count, and the same filter sidebar + product grid layout as the Shop page. If there's room, include a "Popular Searches" chip row just below the heading.
```

---

## User Story 5 — Plant Details
*As a visitor, I want to view full details of a plant so I can decide whether to buy it.*

**Page 6: Product Detail**
```
Generate the Product Detail page for a single plant, e.g. "Monstera Deliciosa." Top navigation bar as established. Below it, a two-column layout: left column is a large product image gallery with thumbnail strip beneath it; right column has the plant name, price, star rating with review count, info badges (Light: Bright Indirect, Water: Weekly, Pet Safe: No), a "Pot Size" selector (Small/Medium/Large pill buttons), a quantity stepper, and a full-width terracotta "Add to Cart" button. Below the two-column section, a tabbed area with "Description," "Care Guide," and "Reviews" tabs (Description tab active with 2-3 sentences of text). Below that, a "You May Also Like" row of related plant cards.
```

---

## User Story 6 — Cart & Checkout
*As a shopper, I want to review my cart and complete checkout so I can purchase my plants.*

**Page 7: Cart**
```
Generate the Cart page. Top navigation bar as established. Page title "Your Cart." Two-column layout: left column (wide) is a list of cart items, each row showing a plant thumbnail, name, pot size, quantity stepper, price, and a remove icon; right column (narrower) is a sticky order summary card with Subtotal, Delivery Fee, a promo code input, Total, and a full-width sage green "Proceed to Checkout" button.
```

**Page 8: Checkout**
```
Generate the Checkout page, matching the Cart page's card and spacing style. Two-column layout: left column has stacked sections — "Delivery Address" form, "Delivery Options" (selectable radio cards for standard/express), and "Payment Method" (card details form with saved card option); right column is the sticky Order Summary card (same styling as Cart), ending in a full-width terracotta "Place Order" button showing the total.
```

**Page 9: Order Confirmation**
```
Generate the Order Confirmation page shown after checkout. Centered content on the page: a sage green checkmark icon, headline "Order Confirmed!", subtext with the order number and estimated delivery date, a summary card listing the purchased items, and two buttons — a terracotta "Track Order" button and a secondary outlined "Continue Shopping" button.
```

---

## User Story 7 — Account Dashboard & Order History
*As a returning customer, I want to manage my account and track my orders.*

**Page 10: Account Dashboard**
```
Generate the Account Dashboard page. Top navigation bar as established. Layout: a left sidebar menu with items "Overview," "My Orders," "Saved Addresses," "Payment Methods," "Wishlist," "Account Settings," and "Log Out" (muted red). Main content area shows the "Overview" panel active: a welcome header with the user's name and avatar, and summary cards for "Recent Order," "Wishlist Items," and "Saved Addresses."
```

**Page 11: Order History / Tracking**
```
Generate the "My Orders" page reached from the Account sidebar. Same sidebar layout as the Account Dashboard, with "My Orders" active. Main area: two tabs "Ongoing" and "Past" (Ongoing active), below which is a list of order cards — each showing a plant thumbnail, order ID, item count, a status pill (e.g. "Out for Delivery" in terracotta), and estimated delivery date. The top ongoing order is expanded to show a horizontal progress tracker with 4 steps: Confirmed → Packed → Out for Delivery → Delivered, current step highlighted in sage green.
```

---

## After all 11 pages are generated

Send this once, at the end, to catch drift:

```
Please review all the pages generated in this session and make sure the color palette (#4A7C59 sage, #C77B4D terracotta, #F7F5F0 background), corner radius, card style, top navigation bar, footer, and typography are perfectly consistent across every page. Flag and fix any page that has drifted from the others.
```

Then export each page to Figma or HTML/CSS as needed.

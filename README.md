---
# Digisol Assignment - Expedia Package Search Application

---

## ✨ Features
- Search for package offers by entering an **origin city** and **destination city**.
- **Configurable API endpoint** to switch between real Expedia API data and mock offers.
- **Integration tests** to ensure the application behaves as expected.
- Easy **configuration** through `application.properties`.

---

## ✅ Prerequisites
- **Java 17**
- **Maven 3.8+**
- An IDE (e.g., IntelliJ IDEA, Eclipse) or terminal for running the app.

---

## ⚙️ Configuration

The application reads its settings from the `src/main/resources/application.properties` file. Below are the key properties you need to configure:

```properties
spring.application.name=digisol-assignment
base.url=https://offersvc.expedia.com
app.api.offers-endpoint=/api/offers
# app.api.offers-endpoint=/api/fake-offers
```

### Property Explanations:
- **`base.url`**  
  The base URL for the Expedia API. Change it if you want to point to another environment (e.g., staging, local).

- **`app.api.offers-endpoint`**  
  Controls which API the frontend will call:
   - `/api/offers` → Connects to the **real Expedia API**.
   - `/api/fake-offers` → Uses **mock data** (useful for testing or avoiding API rate limits).

---

## 🔀 Switching Between Real and Fake Data

### 1. Real Expedia API
- Set in `application.properties`:
  ```properties
  app.api.offers-endpoint=/api/offers
  ```
- The backend will call:  
  `https://offersvc.expedia.com/offers/v2/getOffers`

### 2. Mock Data (Recommended for Testing)
- Set in `application.properties`:
  ```properties
  app.api.offers-endpoint=/api/fake-offers
  ```
- Ensure you have a **`FakeOfferController`** implemented.  
  This controller should return mock offers without calling the external API.

---

## 🚀 Running the Application

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd digisol-assignment
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the App**  
   Open your browser and go to:  
   👉 [http://localhost:8080/](http://localhost:8080/)  
   Enter an **origin city** (e.g., `Seattle`) and a **destination city** (e.g., `New York`) and click **Search**.

---

## ✅ Running Tests

Run integration tests to validate functionality:
 ```bash
   mvn test
   ```

### Test Files
- `OfferControllerIntegrationTest.java`  
  Verifies `/api/offers` functionality with mocked responses.

---

## 🛠️ Troubleshooting

### ❗ [429 Too Many Requests]
- The Expedia API may **throttle** requests. If you hit this error:
   - Switch to the **mock endpoint**: `/api/fake-offers`
   - Implement fallback handling in your service layer.

### ❗ No Offers Displayed?
- Check the **browser console** for JavaScript errors.
- Verify that the **endpoint** in `application.properties` is correct.

### 📜 Logging
- Logs are displayed in the console using **SLF4J**.

---

## 📦 Dependencies
| Library                 | Version  |
|-------------------------|----------|
| Spring Boot             | 3.4.3    |
| Spring Cloud OpenFeign  | 2024.0.0 |
| Thymeleaf               | Latest   |
| Bootstrap               | 5.3.0    |

---
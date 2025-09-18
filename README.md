# 🚀 Selenium WebDriver - Essential Configuration

Quick reference for the Framework Configurations
https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html


### HOW TO RUN THE FRAMEWORK

For specific test cases execution we need to pass this command
```java
mvn clean test -Dtest=MainRunner "-Dcucumber.filter.tags=@yourTag"
```

## 🔧 Essential ChromeOptions

### Basic Setup
```java
ChromeOptions options = new ChromeOptions();
WebDriver driver = new ChromeDriver(options);
```

### Most Common Options

| Option | Purpose | When to Use |
|--------|---------|-------------|
| `--headless` | Run without GUI | CI/CD, background execution |
| `--start-maximized` | Maximize window | Local testing |
| `--no-sandbox` | Disable sandbox | Docker/CI environments |
| `--disable-dev-shm-usage` | Prevent memory issues | Limited memory systems |
| `--window-size=1920,1080` | Set window size | Consistent viewport |

### Quick Configurations

**Local Development:**
```java
options.addArguments("--start-maximized");
options.addArguments("--disable-infobars");
```

**CI/CD Pipeline:**
```java
options.addArguments("--headless");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--window-size=1920,1080");
```

**Performance Boost:**
```java
options.addArguments("--disable-extensions");
options.addArguments("--disable-images");
options.addArguments("--disable-gpu");
```

---

## ⏱️ Implicit Wait Configuration

### Basic Setup
```java
// Modern approach (Selenium 4+)
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// All timeouts
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
```

### Recommended Wait Times

| Environment | Wait Time | Use Case |
|------------|-----------|----------|
| **Fast Apps** | 5 seconds | Static content |
| **Normal Apps** | 10 seconds | ⭐ Most common |
| **Slow Apps** | 15 seconds | Heavy dynamic content |

---

## 🛠️ Complete Examples

### 1. Local Development
```java
public WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    return driver;
}
```

### 2. CI/CD Environment
```java
public WebDriver createCIDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    
    return driver;
}
```

---

## 💡 Quick Tips

### ✅ Best Practices
- Use `--headless` for CI/CD
- Always add `--no-sandbox` for Docker
- Set implicit wait once at initialization
- Use 10 seconds as default wait time

### ⚠️ Common Issues
| Problem | Solution |
|---------|----------|
| Browser won't start | Add `--no-sandbox` |
| Memory errors | Add `--disable-dev-shm-usage` |
| Slow execution | Add `--disable-images` |

---

**⭐ Most Used Setup:**
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");  // Local
// options.addArguments("--headless");      // CI/CD
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");

WebDriver driver = new ChromeDriver(options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```
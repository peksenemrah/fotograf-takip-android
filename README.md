# Fotoğraf Albümü Ödeme Takibi — Android

## APK Oluşturma ve Kurulum (GitHub Actions ile)

### 1. GitHub'a Yükle

1. [github.com](https://github.com) → Ücretsiz hesap aç
2. **New repository** → İsim: `fotograf-takip-android` → **Create**
3. **uploading an existing file** tıkla
4. Bu klasördeki **TÜM dosya ve klasörleri** sürükle-bırak:
   - `app/` klasörü
   - `build.gradle`, `settings.gradle`, `gradle.properties`
   - `.github/` klasörü *(gizli — Finder'da Cmd+Shift+. ile görünür)*
5. **Commit changes** tıkla

### 2. Build Bekle (~5 dakika)

- **Actions** sekmesine git
- Sarı daire → build devam ediyor
- Yeşil tik → tamamlandı

### 3. APK'yı İndir

- **Releases** sekmesine git
- `FotografAlbumuTakip-*.apk` dosyasını indir

### 4. Android Telefona Kur

1. APK dosyasını WhatsApp, Google Drive veya USB ile telefona aktar
2. Dosyaya dokun
3. "Bilinmeyen kaynaklardan yükle" → İzin Ver
4. Kur → Aç

---

## Proje Yapısı

```
fotograf-takip-android/
├── app/
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/fotograf/takip/
│       │   └── MainActivity.java     ← WebView ana ekran
│       ├── assets/www/
│       │   └── index.html            ← Uygulama (HTML/CSS/JS)
│       └── res/                      ← İkonlar, layout, tema
├── build.gradle
├── settings.gradle
├── gradle.properties
└── .github/workflows/
    └── build-apk.yml                 ← Otomatik APK build
```

## Not

Uygulama verileri (sınıflar, öğrenciler, ödemeler) telefon hafızasında kalıcı olarak saklanır. Uygulama silinirse veriler de silinir — önemli veriler için **Ayarlar → Yedek Al** özelliğini kullanın.

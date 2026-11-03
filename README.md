<div align="center">

<img src="assets/banner.svg" alt="PlotsquaredModFix" width="100%">

# PlotsquaredModFix

**PlotSquared 地块 Mod 物品保护** —— 在不属于玩家的地块内拦截 Mod 物品（扳手等）交互。

![Platform](https://img.shields.io/badge/Platform-Spigot%20%2F%20Paper-62bda8?style=flat-square&logo=minecraft&logoColor=white)
![Minecraft](https://img.shields.io/badge/MC-1.20.x-8a9a5b?style=flat-square)
![Java](https://img.shields.io/badge/Java-17-f89820?style=flat-square&logo=openjdk&logoColor=white)
![Depends](https://img.shields.io/badge/softdepend-PlaceholderAPI-e2b90f?style=flat-square)

[功能](#-功能) · [配置](#️-配置)

</div>

## ✨ 功能

- **地块边界拦截**：只在 `enabledWorlds` 的 PlotSquared 世界生效，非本人地块内右键使用受限物品即取消
- **自定义提示**：`messages.cannotUseRightClick` 文案可配
- **轻量单类实现**：一个监听器解决问题，零额外依赖

> 同系列插件：[BentoBoxModFix](https://github.com/windy664/BentoBoxModFix) · [IridiumSkyblockModTweaks](https://github.com/windy664/IridiumSkyblockModTweaks) · [HusktownsPrevent](https://github.com/windy664/HusktownsPrevent)

## ⚙️ 配置

```yaml
enabledWorlds:
  - plot

messages:
  cannotUseRightClick: "You cannot interact here!"
```

## 🔨 构建

```bash
./gradlew build
```

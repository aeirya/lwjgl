// package com.bubble.athena.client;

// public class ModuleManager {

//     private final EventManager eventManager;

 
//     public ModuleManager(Game game) {
//         this.game = game;
        
//     }

//     private final ModuleLocator initiateModuleLocator() {
//         return ModuleLocator
//             .provideInstance(new ModuleLocator())
//             .provideGui(gui)
//             .provideRenderer(renderer)
//             .provideLogic(game);
//     }

//     private final EventBus initiateEventBus(Game game) {
//         return new EventBus(null);
//     }

//     private final IGraphics initiateGraphics() {
//         return new OpenGlGraphics(renderer, gui);
//     }

//     private final IRenderer initiateRenderer() {
//         return new Renderer();
//     }

//     private final GameInput initiateInput() {
//         return new GameInput(gui);
//     }

//     private final GuiManager initiateGuiManager() {
//         return new GuiManager();
//     }

//     private final EventSystem initiateEventSystem() {
//         return new EventSystem(eventManager);
//     }

//     private final EventManager initiateEventManager() {
//         return new EventManager(locator, eventBus);
//     }

//     public ModuleLocator getModules() {
//         return locator;
//     }

//     private void initiateEngine() {
//         EventSystem.start(eventSystem);
//     }

//     public void start() {
//         initiateEngine();
//         gui.start();
//         input.start();
//         graphics.start();
//         renderer.start();
//         // start components
//         // network.start();
//     }
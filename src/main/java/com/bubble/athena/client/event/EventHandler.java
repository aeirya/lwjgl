// package com.bubble.athena.client.event;

// import com.bubble.std.Queue;

// public class EventHandler implements IEventHandler {
//     private final Queue<IEvent> queue;
//     private static final int WAIT_TIME = 10;
//     private boolean isAlive = true;
//     private final Object lock = new Object();

//     public EventHandler() {
//         this.queue = new Queue<>();
//     }

//     public void start() {
//         new Thread(this::run).start();
//     }

//     private void run() {
//         while (true) {
//             while(queue.hasNext()) process(event);   
//             sleep(); 
//         }
//     }

//     private void sleep() {
//         try {
//             synchronized(lock) {
//                 while (! queue.hasNext()) {
//                     wait();
//                 }
//             }
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//             Thread.currentThread().interrupt();
//         }
//     }

//     public void handle(IEvent event) {
//         queue.push(event);
//     }

//     private void process(IEvent event) {
//         event.process(this);
//     }

// }
# SimpleCaching
Simple app that fetches data from a REST API using Retrofit, and caches this data for offline use in an SQLite database using the Room persistence library. For this, I use a NetworkBoundResource implementation based on Kotlin Coroutines and Kotlin Flow.
The app will follow a simple MVVM architecture with dependency injection, single source of truth principle, and separation of concerns.

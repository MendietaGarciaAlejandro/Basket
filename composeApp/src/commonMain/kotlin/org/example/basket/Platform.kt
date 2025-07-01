package org.example.basket

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
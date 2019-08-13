package io.github.keep2iron.peach.core

interface FlipCreator {
  fun flip(boolean: Boolean = true): FlipCreator
  fun orientation(orientation: Int): FlipCreator
  fun flipVertical(): FlipCreator
  fun complete(): AbstractCreator
}
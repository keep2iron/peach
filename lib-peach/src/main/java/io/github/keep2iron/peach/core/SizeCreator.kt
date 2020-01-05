package io.github.keep2iron.peach.core

import io.github.keep2iron.peach.Peach

interface SizeCreator {
  fun width(width: Int): Peach
  fun height(height: Int): Peach
  fun size(width: Int, height: Int): Peach
  fun size(size: Int): Peach
  fun complete(): AbstractCreator
}
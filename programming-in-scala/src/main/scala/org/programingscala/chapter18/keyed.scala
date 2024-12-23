package org.programingscala.chapter18

class Keyed {
  def computeKey: Int = {
    123
  }
}

class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None

  override def computeKey: Int = {
    if (keyCache.isEmpty) keyCache = Some(super.computeKey)
    keyCache.get
  }
}

package crew.chisel.amba.apb

import pureconfig.ConfigSource
import pureconfig.generic.auto._

case class Config(
  addrWidth: Int,
  dataWidth: Int,
  protWidth: Int,
  strbWidth: Int
)

object ApbConfig {
  private val dummyCfg = Config(1, 1, 1, 1)

  def loadConfig() = ConfigSource.default.load[Config].getOrElse(dummyCfg)

}

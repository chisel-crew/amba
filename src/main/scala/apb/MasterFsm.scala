package crew.chisel.amba.apb

import chisel3._
import chisel3.util.{ Enum }

class MasterFsm(p: Config) extends Module {
  val io = IO(new ApbLink(p))

  val sNone :: sReq :: sWack :: sWfin :: Nil = Enum(3)
  val state                                  = RegInit(sNone)
}

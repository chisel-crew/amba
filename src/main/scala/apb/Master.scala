package crew.chisel.amba.apb

import chisel3._
import chisel3.util._

class Master(p: Config) extends Module {
  val io = IO(new ApbLink(p))

  val sIdle :: sWSetup :: sWAccess :: sWfin :: Nil = Enum(4)

  val state = RegInit(sIdle)

  val start = false.B

  switch(state) {

    // Idle phase
    is(sIdle) {
      io.paddr := UInt(0.W)
      io.pprot := UInt(0.W)
      io.psel := false.B
      io.penable := false.B
      io.pwrite := false.B
      io.pwdata := UInt(0.W)
      io.pstrb := UInt(0.W)

      when(start) {
        state := sWSetup
      }

    }

    // Setup phase
    is(sWSetup) {
      io.pwrite := true.B
      io.paddr := ???
      io.pwdata := ???
      io.pstrb := UInt(1.W)
      io.pprot := UInt(1.W)

      io.psel := true.B
      io.penable := false.B

      io.pwrite := true.B

      state := sWAccess
    }

    // Access phase
    is(sWAccess) {
      io.penable := true.B

      when(!io.pready) {
        state := sWfin
      }

    }

    // Finish phase
    // Here FSM either proceeds with another transfer or goes idle
    is(sWSetup) {}
  }

}

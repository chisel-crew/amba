package crew.chisel.amba.apb

import chisel3._
import chisel3.util._

class Master(p: Config) extends Module {
  val io = IO(new Bundle {
    val io  = new SimpleLink(p)
    val apb = new ApbLink(p)
  })

  val sIdle :: sWSetup :: sWAccess :: sWfin :: Nil = Enum(4)

  val state = RegInit(sIdle)

  val start = false.B

  switch(state) {

    // Idle phase
    is(sIdle) {
      io.apb.paddr := UInt(0.W)
      io.apb.pprot := UInt(0.W)
      io.apb.psel := false.B
      io.apb.penable := false.B
      io.apb.pwrite := false.B
      io.apb.pwdata := UInt(0.W)
      io.apb.pstrb := UInt(0.W)

      when(start) {
        state := sWSetup
      }

    }

    // Setup phase
    is(sWSetup) {
      io.apb.pwrite := true.B
      io.apb.paddr := io.io.addr
      io.apb.pwdata := io.io.wdata
      io.apb.pstrb := UInt(1.W)
      io.apb.pprot := UInt(1.W)

      io.apb.psel := true.B
      io.apb.penable := false.B

      io.apb.pwrite := true.B

      state := sWAccess
    }

    // Access phase
    is(sWAccess) {
      io.apb.penable := true.B

      when(!io.apb.pready) {
        state := sWfin
      }

    }

    // Finish phase
    // Here FSM either proceeds with another transfer or goes idle
    is(sWSetup) {}
  }

}

import chisel3._
import chisel3.util._

class DetectTwoOnes extends Module {
  val io = IO(new Bundle {
    val in  = Input(Bool())
    val out = Output(Bool())
  })

  val sNone :: sOne1 :: sTwo1s :: Nil = Enum(3)
  val state                           = RegInit(sNone)

  io.out := (state === sTwo1s)

  switch(state) {
    is(sNone) {
      when(io.in) {
        state := sOne1
      }
    }
    is(sOne1) {
      when(io.in) {
        state := sTwo1s
      }.otherwise {
        state := sNone
      }
    }
    is(sTwo1s) {
      when(!io.in) {
        state := sNone
      }
    }
  }
}

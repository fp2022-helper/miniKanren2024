// Autogenerated file
@file:Suppress("FunctionName", "NonAsciiCharacters", "TestFunctionName")

package utils

import org.klogic.core.*
import org.klogic.utils.terms.LogicList
import org.klogic.utils.terms.LogicList.Companion.logicListOf
import org.klogic.utils.terms.Nil.nilLogicList
import org.klogic.utils.terms.plus
import utils.LogicInt.Companion.toLogic

val digitZero: Digit = 0.toLogic()
val digitOne: Digit = 1.toLogic()

typealias Digit = LogicInt
typealias OlegLogicNumber = LogicList<Digit>
typealias OlegTerm = Term<OlegLogicNumber>

val zero: OlegLogicNumber = logicListOf()
val one: OlegLogicNumber = logicListOf( 1.toLogic() )
val three: OlegLogicNumber = logicListOf( 1.toLogic(), 1.toLogic() )

fun UInt.toOlegLogicNumber(): OlegLogicNumber = toLogicList()
fun UInt.toLogicList(): LogicList<Digit> =
    when {
        this == 0u -> nilLogicList()
        this % 2u == 0u -> digitZero + (this / 2u).toLogicList()
        else -> digitOne + (this / 2u).toLogicList()
    }

context(RelationalContext)
fun  pause(f: () -> Goal): Goal = { st -> ThunkStream { f()(st) } }

// There are 23 relations
context(RelationalContext)
fun  full_addero(b: Term<LogicInt>, x: Term<LogicInt>, y: Term<LogicInt>,
      r: Term<LogicInt>, c: Term<LogicInt>): Goal =
  conde(and(and(0.toLogic() `===` b, 0.toLogic() `===` x),
            0.toLogic() `===` y,
            0.toLogic() `===` r,
            0.toLogic() `===` c),
        and(and(1.toLogic() `===` b, 0.toLogic() `===` x),
            0.toLogic() `===` y,
            1.toLogic() `===` r,
            0.toLogic() `===` c),
        and(and(0.toLogic() `===` b, 1.toLogic() `===` x),
            0.toLogic() `===` y,
            1.toLogic() `===` r,
            0.toLogic() `===` c),
        and(and(1.toLogic() `===` b, 1.toLogic() `===` x),
            0.toLogic() `===` y,
            0.toLogic() `===` r,
            1.toLogic() `===` c),
        and(and(0.toLogic() `===` b, 0.toLogic() `===` x),
            1.toLogic() `===` y,
            1.toLogic() `===` r,
            0.toLogic() `===` c),
        and(and(1.toLogic() `===` b, 0.toLogic() `===` x),
            1.toLogic() `===` y,
            0.toLogic() `===` r,
            1.toLogic() `===` c),
        and(and(0.toLogic() `===` b, 1.toLogic() `===` x),
            1.toLogic() `===` y,
            0.toLogic() `===` r,
            1.toLogic() `===` c),
        and(and(1.toLogic() `===` b, 1.toLogic() `===` x),
            1.toLogic() `===` y,
            1.toLogic() `===` r,
            1.toLogic() `===` c))

context(RelationalContext)
fun  zeroo(n: Term<LogicList<LogicInt>>): Goal =
  n `===` nilLogicList()

context(RelationalContext)
fun  poso(n: Term<LogicList<LogicInt>>): Goal =
  freshTypedVars { h: Term<LogicInt>, t: Term<LogicList<LogicInt>> ->
  (n `===` (h + t)) }

context(RelationalContext)
fun  appendo(l: Term<LogicList<LogicInt>>, s: Term<LogicList<LogicInt>>,
      out: Term<LogicList<LogicInt>>): Goal =
  conde(and(l `===` nilLogicList(), s `===` out),
        freshTypedVars { a: Term<LogicInt>, d: Term<LogicList<LogicInt>>,
          res: Term<LogicList<LogicInt>> ->
        and((a + d) `===` l,
            (a + res) `===` out,
            appendo(d, s, res))
        })

context(RelationalContext)
fun  gt1o(n: Term<LogicList<LogicInt>>): Goal =
  freshTypedVars { a: Term<LogicInt>, ad: Term<LogicInt>,
    dd: Term<LogicList<LogicInt>> ->
  (n `===` (a + (ad + dd))) }

context(RelationalContext)
fun  addero(d: Term<LogicInt>, n: Term<LogicList<LogicInt>>,
      m: Term<LogicList<LogicInt>>, r: Term<LogicList<LogicInt>>): Goal =
  conde(and(0.toLogic() `===` d,
            m `===` nilLogicList(),
            n `===` r),
        and(0.toLogic() `===` d,
            n `===` nilLogicList(),
            m `===` r,
            poso(m)),
        and(1.toLogic() `===` d,
            m `===` nilLogicList(),
            pause { addero(0.toLogic(), n, one, r) }),
        and(1.toLogic() `===` d,
            n `===` nilLogicList(),
            poso(m),
            pause { addero(0.toLogic(), m, one, r) }),
        and(n `===` one,
            m `===` one,
            freshTypedVars { a: Term<LogicInt>, c: Term<LogicInt> ->
            and((a + (c + nilLogicList())) `===` r,
                full_addero(d, 1.toLogic(), 1.toLogic(), a, c))
            }),
        and(n `===` one, gen_addero(d, n, m, r)),
        and(m `===` one,
            gt1o(n),
            gt1o(r),
            pause { addero(d, one, n, r) }),
        and(gt1o(n), gen_addero(d, n, m, r)))

context(RelationalContext)
fun  gen_addero(d: Term<LogicInt>, n: Term<LogicList<LogicInt>>,
      m: Term<LogicList<LogicInt>>, r: Term<LogicList<LogicInt>>): Goal =
  freshTypedVars { a : Term<LogicInt>,  b : Term<LogicInt>,
   c : Term<LogicInt>,  e : Term<LogicInt>,  x : Term<LogicList<LogicInt>> ->
  freshTypedVars { y: Term<LogicList<LogicInt>>,
    z: Term<LogicList<LogicInt>> ->
  and((a + x) `===` n,
      (b + y) `===` m,
      poso(y),
      (c + z) `===` r,
      poso(z),
      full_addero(d, a, b, c, e),
      addero(e, x, y, z))
  } }

context(RelationalContext)
fun  pluso(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>,
      k: Term<LogicList<LogicInt>>): Goal =
  addero(0.toLogic(), n, m, k)

context(RelationalContext)
fun  minuso(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>,
      k: Term<LogicList<LogicInt>>): Goal =
  pluso(m, k, n)

context(RelationalContext)
fun  bound_multo(q: Term<LogicList<LogicInt>>, p: Term<LogicList<LogicInt>>,
      n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>): Goal =
  conde(and(q `===` zero, poso(p)),
        freshTypedVars { a0 : Term<LogicInt>,  a1 : Term<LogicInt>,
         a2 : Term<LogicInt>,  a3 : Term<LogicInt>,
         x : Term<LogicList<LogicInt>> ->
        freshTypedVars { y: Term<LogicList<LogicInt>>,
          z: Term<LogicList<LogicInt>> ->
        and(q `===` (a0 + x),
            p `===` (a1 + y),
            conde(and(n `===` zero,
                      m `===` (a2 + z),
                      bound_multo(x, y, z, zero)),
                  and(n `===` (a3 + z), bound_multo(x, y, z, m))))
        } })

context(RelationalContext)
fun  multo(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>,
      p: Term<LogicList<LogicInt>>): Goal =
  conde(and(n `===` zero, p `===` zero),
        and(poso(n),
            m `===` zero,
            p `===` zero),
        and(n `===` one,
            poso(m),
            m `===` p),
        and(gt1o(n),
            m `===` one,
            n `===` p),
        freshTypedVars { x: Term<LogicList<LogicInt>>,
          z: Term<LogicList<LogicInt>> ->
        and(n `===` (0.toLogic() + x),
            poso(x),
            p `===` (0.toLogic() + z),
            poso(z),
            gt1o(m),
            multo(x, m, z))
        },
        freshTypedVars { x: Term<LogicList<LogicInt>>,
          y: Term<LogicList<LogicInt>> ->
        and(n `===` (1.toLogic() + x),
            poso(x),
            m `===` (0.toLogic() + y),
            poso(y),
            multo(m, n, p))
        },
        freshTypedVars { x: Term<LogicList<LogicInt>>,
          y: Term<LogicList<LogicInt>> ->
        and(n `===` (1.toLogic() + x),
            poso(x),
            m `===` (1.toLogic() + y),
            poso(y),
            odd_multo(x, n, m, p))
        })

context(RelationalContext)
fun  odd_multo(x: Term<LogicList<LogicInt>>, n: Term<LogicList<LogicInt>>,
      m: Term<LogicList<LogicInt>>, p: Term<LogicList<LogicInt>>): Goal =
  freshTypedVars { q: Term<LogicList<LogicInt>> ->
  and(bound_multo(q, p, n, m),
      multo(x, m, q),
      pluso((0.toLogic() + q), m, p))
  }

context(RelationalContext)
fun  eqlo(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>): Goal =
  conde(and(n `===` zero, m `===` zero),
        and(n `===` one, m `===` one),
        freshTypedVars { a: Term<LogicInt>, x: Term<LogicList<LogicInt>>,
          b: Term<LogicInt>, y: Term<LogicList<LogicInt>> ->
        and((a + x) `===` n,
            poso(x),
            (b + y) `===` m,
            poso(y),
            eqlo(x, y))
        })

context(RelationalContext)
fun  ltlo(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>): Goal =
  conde(and(n `===` zero, poso(m)),
        and(n `===` one, gt1o(m)),
        freshTypedVars { a: Term<LogicInt>, x: Term<LogicList<LogicInt>>,
          b: Term<LogicInt>, y: Term<LogicList<LogicInt>> ->
        and((a + x) `===` n,
            poso(x),
            (b + y) `===` m,
            poso(y),
            ltlo(x, y))
        })

context(RelationalContext)
fun  lelo(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>): Goal =
  conde(eqlo(n, m),
        ltlo(n, m))

context(RelationalContext)
fun  lto(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>): Goal =
  conde(ltlo(n, m),
        and(eqlo(n, m),
         freshTypedVars { x: Term<LogicList<LogicInt>> ->
         and(poso(x),
             pluso(n, x, m))
         }))

context(RelationalContext)
fun  leo(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>): Goal =
  conde(n `===` m,
        lto(n, m))

context(RelationalContext)
fun  splito(n: Term<LogicList<LogicInt>>, r: Term<LogicList<LogicInt>>,
      l: Term<LogicList<LogicInt>>, h: Term<LogicList<LogicInt>>): Goal =
  conde(and(n `===` zero,
            h `===` zero,
            l `===` zero),
        freshTypedVars { b: Term<LogicInt>, n_: Term<LogicList<LogicInt>> ->
        and(n `===` (0.toLogic() + (b + n_)),
            r `===` zero,
            h `===` (b + n_),
            l `===` zero)
        },
        freshTypedVars { n_: Term<LogicList<LogicInt>> ->
        and(n `===` (1.toLogic() + n_),
            r `===` zero,
            n_ `===` h,
            l `===` one)
        },
        freshTypedVars { b: Term<LogicInt>, n_: Term<LogicList<LogicInt>>,
          a: Term<LogicInt>, r_: Term<LogicList<LogicInt>> ->
        and(n `===` (0.toLogic() + (b + n_)),
            (a + r_) `===` r,
            l `===` zero,
            splito((b + n_), r_, zero, h))
        },
        freshTypedVars { n_: Term<LogicList<LogicInt>>, a: Term<LogicInt>,
          r_: Term<LogicList<LogicInt>> ->
        and(n `===` (1.toLogic() + n_),
            r `===` (a + r_),
            l `===` one,
            splito(n_, r_, zero, h))
        },
        freshTypedVars { b: Term<LogicInt>, n_: Term<LogicList<LogicInt>>,
          a: Term<LogicInt>, r_: Term<LogicList<LogicInt>>,
          l_: Term<LogicList<LogicInt>> ->
        and(n `===` (b + n_),
            r `===` (a + r_),
            l `===` (b + l_),
            poso(l_),
            splito(n_, r_, l_, h))
        })

context(RelationalContext)
fun  divo(n: Term<LogicList<LogicInt>>, m: Term<LogicList<LogicInt>>,
      q: Term<LogicList<LogicInt>>, r: Term<LogicList<LogicInt>>): Goal =
  conde(and(r `===` n,
            q `===` zero,
            lto(n, m)),
        and(q `===` one,
            eqlo(n, m),
            pluso(r, m, n),
            lto(r, m)),
        and(ltlo(m, n),
            lto(r, m),
            poso(q),
            freshTypedVars { nh : Term<LogicList<LogicInt>>,
             nl : Term<LogicList<LogicInt>>,  qh : Term<LogicList<LogicInt>>,
             ql : Term<LogicList<LogicInt>>,
             qlm : Term<LogicList<LogicInt>> ->
            freshTypedVars { qlmr: Term<LogicList<LogicInt>>,
              rr: Term<LogicList<LogicInt>>, rh: Term<LogicList<LogicInt>> ->
            and(splito(n, r, nl, nh),
                splito(q, r, ql, qh),
                conde(and(nh `===` zero,
                          qh `===` zero,
                          minuso(nl, r, qlm),
                          multo(ql, m, qlm)),
                      and(and(poso(nh),
                              multo(ql, m, qlm),
                              pluso(qlm, r, qlmr)),
                          minuso(qlmr, nl, rr),
                          splito(rr, r, zero, rh),
                          divo(nh, m, qh, rh))))
            } }))

context(RelationalContext)
fun  repeated_mul(n: Term<LogicList<LogicInt>>, q: Term<LogicList<LogicInt>>,
      nq: Term<LogicList<LogicInt>>): Goal =
  conde(and(poso(n),
            q `===` zero,
            nq `===` one),
        and(q `===` one, n `===` nq),
        and(gt1o(q),
         freshTypedVars { q1: Term<LogicList<LogicInt>>,
           nq1: Term<LogicList<LogicInt>> ->
         and(pluso(q1, one, q),
             repeated_mul(n, q1, nq1),
             multo(nq1, n, nq))
         }))

context(RelationalContext)
fun  exp2(n: Term<LogicList<LogicInt>>, b: Term<LogicList<LogicInt>>,
      q: Term<LogicList<LogicInt>>): Goal =
  conde(and(n `===` one, q `===` zero),
        and(gt1o(n),
            q `===` one,
            freshTypedVars { s: Term<LogicList<LogicInt>> ->
            splito(n, b, s, one) }),
        freshTypedVars { q1: Term<LogicList<LogicInt>>,
          b2: Term<LogicList<LogicInt>> ->
        and(q `===` (0.toLogic() + q1),
            poso(q1),
            ltlo(b, n),
            appendo(b, (1.toLogic() + b), b2),
            exp2(n, b2, q1))
        },
        freshTypedVars { q1: Term<LogicList<LogicInt>>,
          nh: Term<LogicList<LogicInt>>, b2: Term<LogicList<LogicInt>>,
          s: Term<LogicList<LogicInt>> ->
        and(q `===` (1.toLogic() + q1),
            poso(q1),
            poso(nh),
            splito(n, b, s, nh),
            appendo(b, (1.toLogic() + b), b2),
            exp2(nh, b2, q1))
        })

context(RelationalContext)
fun  logo(n: Term<LogicList<LogicInt>>, b: Term<LogicList<LogicInt>>,
      q: Term<LogicList<LogicInt>>, r: Term<LogicList<LogicInt>>): Goal =
  conde(and(n `===` one,
            poso(b),
            q `===` zero,
            r `===` zero),
        and(q `===` zero,
            lto(n, b),
            pluso(r, one, n)),
        and(q `===` one,
            gt1o(b),
            eqlo(n, b),
            pluso(r, b, n)),
        and(b `===` one,
            poso(q),
            pluso(r, one, n)),
        and(b `===` zero,
            poso(q),
            r `===` n),
        and((0.toLogic() + (1.toLogic() + nilLogicList())) `===` b,
         freshTypedVars { a: Term<LogicInt>, ad: Term<LogicInt>,
           dd: Term<LogicList<LogicInt>> ->
         and(poso(dd),
             n `===` (a + (ad + dd)),
             exp2(n, nilLogicList(), q),
             freshTypedVars { s: Term<LogicList<LogicInt>> ->
             splito(n, dd, r, s) })
         }),
        and(freshTypedVars { a: Term<LogicInt>, ad: Term<LogicInt>,
              add: Term<LogicInt>, ddd: Term<LogicList<LogicInt>> ->
            conde(b `===` three,
                  b `===` (a + (ad + (add + ddd))))
            },
            ltlo(b, n),
            freshTypedVars { bw1 : Term<LogicList<LogicInt>>,
             bw : Term<LogicList<LogicInt>>,  nw : Term<LogicList<LogicInt>>,
             nw1 : Term<LogicList<LogicInt>>,
             ql1 : Term<LogicList<LogicInt>> ->
            freshTypedVars { ql: Term<LogicList<LogicInt>>,
              s: Term<LogicList<LogicInt>> ->
            and(exp2(b, zero, bw1),
                pluso(bw1, one, bw),
                ltlo(q, n),
                freshTypedVars { q1: Term<LogicList<LogicInt>>,
                  bwq1: Term<LogicList<LogicInt>> ->
                and(pluso(q, one, q1),
                    multo(bw, q1, bwq1),
                    lto(nw1, bwq1))
                },
                exp2(n, zero, nw1),
                pluso(nw1, one, nw),
                divo(nw, bw, ql1, s),
                pluso(ql, one, ql1),
                lelo(ql, q),
                freshTypedVars { bql: Term<LogicList<LogicInt>>,
                  qh: Term<LogicList<LogicInt>>,
                  s2: Term<LogicList<LogicInt>>,
                  qdh: Term<LogicList<LogicInt>>,
                  qd: Term<LogicList<LogicInt>> ->
                and(repeated_mul(b, ql, bql),
                    divo(nw, bw1, qh, s2),
                    pluso(ql, qdh, qh),
                    pluso(ql, qd, q),
                    leo(qd, qdh),
                    freshTypedVars { bqd: Term<LogicList<LogicInt>>,
                      bq1: Term<LogicList<LogicInt>>,
                      bq: Term<LogicList<LogicInt>> ->
                    and(repeated_mul(b, qd, bqd),
                        multo(bql, bqd, bq),
                        multo(b, bq, bq1),
                        pluso(bq, r, n),
                        lto(n, bq1))
                    })
                })
            } }))

context(RelationalContext)
fun  expo(b: Term<LogicList<LogicInt>>, q: Term<LogicList<LogicInt>>,
      n: Term<LogicList<LogicInt>>): Goal =// Put epilogue here 

  logo(n, b, q, zero)


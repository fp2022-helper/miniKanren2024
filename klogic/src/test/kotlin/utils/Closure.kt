// Autogenerated file
@file:Suppress("FunctionName", "NonAsciiCharacters", "TestFunctionName"
  , "PropertyName", "ClassName", "LocalVariableName", "SpellCheckingInspection"
  , "PARAMETER_NAME_CHANGED_ON_OVERRIDE", "NAME_SHADOWING"
  )

package utils.JGS.Closure

import org.klogic.core.*
import org.klogic.utils.terms.*
import org.klogic.utils.terms.LogicBool.Companion.toLogicBool
import org.klogic.utils.terms.Nil.nilLogicList
import utils.LogicInt
import utils.LogicInt.Companion.toLogic

import utils.JGS.*
import utils.JGS.Var
import utils.Some
import utils.None
import utils.LogicOption

@Suppress("UNCHECKED_CAST")
fun <T: Term<T>> None(): LogicOption<T> = utils.None as LogicOption<T>

context(RelationalContext)
fun  pause(f: () -> Goal): Goal = { st -> ThunkStream { f()(st) } }

// There are 3 relations
context(RelationalContext)
fun <B : Term<B>, A : Term<A>> list_same_length(xs: Term<LogicList<A>>,
      ys: Term<LogicList<B>>): Goal =
  conde(freshTypedVars { h1: Term<A>, h2: Term<B>, tl1: Term<LogicList<A>>,
          tl2: Term<LogicList<B>> ->
        and(xs `===` (h1 + tl1),
            ys `===` (h2 + tl2),
            list_same_length(tl1, tl2))
        },
        and(xs `===` nilLogicList(),
            ys `===` nilLogicList()))

// CLOSURE 
interface CLOSURE {
  
  context(RelationalContext)
  fun direct_subtyping(v1: (Term<Jtype<LogicInt>>, Goal, Goal) -> Goal,
  v2: ((Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal, Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal,
  v3: Goal, v4: Term<Jtype<LogicInt>>, v5: Term<Jtype<LogicInt>> ): Goal
  
  context(RelationalContext)
  fun closure(v6: (Term<Jtype<LogicInt>>, Goal, Goal) -> Goal,
  v7: ((Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal, Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal,
  v8: Goal, v9: Term<Jtype<LogicInt>>, v10: Term<Jtype<LogicInt>> ): Goal
  
  //  Functions [is_correct_type], [(-<-)], [( <-< )] are not required to be public for OCaml,
  //       but the way we put 'override' identifier in Kotlin requires making it visible 
  context(RelationalContext)
  fun is_correct_type(
  v11: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
  v12: Term<Jtype<LogicInt>> ): Goal
  
  context(RelationalContext)
  fun minus_less_minus(
  v13: ((Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal, Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal,
  v14: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
  v15: (Term<Jtype<LogicInt>>) -> Goal, v16: Term<Jtype<LogicInt>>,
  v17: Term<Jtype<LogicInt>> ): Goal
  
  context(RelationalContext)
  fun greater_minus_greater(
  v18: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal, v19: Goal,
  v20: Term<Jtype<LogicInt>>, v21: Term<Jtype<LogicInt>> ): Goal
  
  context(RelationalContext)
  fun less_minus_less(
  v22: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal, v23: Goal,
  v24: Term<Jtype<LogicInt>>, v25: Term<Jtype<LogicInt>> ): Goal
  
  context(RelationalContext)
  fun less_minus_greater(v26: (Term<Jtype<LogicInt>>, Goal, Goal) -> Goal,
  v27: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal, v28: Goal,
  v29: Term<Jtype<LogicInt>>, v30: Term<Jtype<LogicInt>> ): Goal
  }

// functor
val Closure : (CLASSTABLE) -> CLOSURE = { CT: CLASSTABLE ->
object: CLOSURE {
  context(RelationalContext)
  override fun  is_correct_type(closure_subtyping: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
        t: Term<Jtype<LogicInt>>): Goal =
    conde(freshTypedVars { elems: Term<Jtype<LogicInt>> ->
          (t `===` Array_(elems)) },
          freshTypedVars { id: Term<LogicInt>,
            actual_params: Term<LogicList<Jarg<Jtype<LogicInt>>>>,
            expected_params: Term<LogicList<Jtype<LogicInt>>>,
            super_: Term<Jtype<LogicInt>>,
            supers: Term<LogicList<Jtype<LogicInt>>> ->
          and(t `===` Class_(id, actual_params),
              CT.decl_by_id(id, C(expected_params, super_, supers)),
              list_same_length(expected_params, actual_params))
          },
          freshTypedVars { id: Term<LogicInt>,
            actual_params: Term<LogicList<Jarg<Jtype<LogicInt>>>>,
            expected_params: Term<LogicList<Jtype<LogicInt>>>,
            supers: Term<LogicList<Jtype<LogicInt>>> ->
          and(t `===` Interface(id, actual_params),
              CT.decl_by_id(id, I(expected_params, supers)),
              list_same_length(expected_params, actual_params))
          },
          freshTypedVars { id: Term<LogicInt>, index: Term<PeanoLogicNumber>,
            upb: Term<Jtype<LogicInt>>, lwb: Term<Jtype<LogicInt>> ->
          and(t `===` Var(id, index, upb, Some(lwb)),
              upb `!==` lwb,
              closure_subtyping(lwb, upb))
          },
          freshTypedVars { id: Term<LogicInt>, index: Term<PeanoLogicNumber>,
            upb: Term<Jtype<LogicInt>> ->
          (t `===` Var(id, index, upb, None())) },
          t `===` Null(),
          freshTypedVars { args: Term<LogicList<Jtype<LogicInt>>> ->
          (t `===` Intersect(args)) })
  
  
  context(RelationalContext)
  override fun  minus_less_minus(open_direct_subtyping: ((Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal, Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal,
        closure_subtyping: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
        is_correct_type: (Term<Jtype<LogicInt>>) -> Goal,
        ta: Term<Jtype<LogicInt>>, tb: Term<Jtype<LogicInt>>): Goal =
    pause { and(open_direct_subtyping({ a: Term<Jtype<LogicInt>>, b: Term<Jtype<LogicInt>>, 
                                      rez: Term<LogicBool> -> pause { 
                                                              and(rez `===` true.toLogicBool(),
                                                                  closure_subtyping(a,
                                                                  b))
                                                              } },
                ta, tb, true.toLogicBool()),
                is_correct_type(ta),
                is_correct_type(tb))
    }
  
  
  context(RelationalContext)
  override fun  less_minus_less(direct_subtyping: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
        query_constr: Goal, ta: Term<Jtype<LogicInt>>,
        tb: Term<Jtype<LogicInt>>): Goal =
    pause { and(query_constr,
                only_classes_interfaces_and_arrays(ta),
                only_classes_interfaces_and_arrays(tb),
                conde(direct_subtyping(ta, tb),
                      freshTypedVars { ti: Term<Jtype<LogicInt>> ->
                      and(tb `!==` ti,
                          ta `!==` ti,
                          ta `!==` tb,
                          only_classes_interfaces_and_arrays(ti),
                          direct_subtyping(ti, tb),
                          less_minus_less(direct_subtyping, query_constr, ta,
                          ti))
                      }))
    }
  
  
  context(RelationalContext)
  override fun  greater_minus_greater(direct_subtyping: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
        query_constr: Goal, ta: Term<Jtype<LogicInt>>,
        tb: Term<Jtype<LogicInt>>): Goal =
    pause { and(query_constr,
                only_classes_interfaces_and_arrays(ta),
                only_classes_interfaces_and_arrays(tb),
                conde(direct_subtyping(ta, tb),
                      freshTypedVars { ti: Term<Jtype<LogicInt>> ->
                      and(tb `!==` ti,
                          ta `!==` ti,
                          ta `!==` tb,
                          only_classes_interfaces_and_arrays(ti),
                          direct_subtyping(ta, ti),
                          greater_minus_greater(direct_subtyping,
                          query_constr, ti, tb))
                      }))
    }
  
  
  context(RelationalContext)
  override fun  less_minus_greater(debug_var_handler: (Term<Jtype<LogicInt>>, Goal, Goal) -> Goal,
        direct_subtyping: (Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>) -> Goal,
        query_constr: Goal, ta: Term<Jtype<LogicInt>>,
        tb: Term<Jtype<LogicInt>>): Goal =
    debug_var_handler(ta,
    less_minus_less(direct_subtyping, query_constr, ta, tb),
    greater_minus_greater(direct_subtyping, query_constr, ta, tb))
  
  
  context(RelationalContext)
  override fun  direct_subtyping(debug_var_handler: (Term<Jtype<LogicInt>>, Goal, Goal) -> Goal,
        open_direct_subtyping: ((Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal, Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal,
        query_constr: Goal, ta: Term<Jtype<LogicInt>>,
        tb: Term<Jtype<LogicInt>>): Goal =
    minus_less_minus(open_direct_subtyping,
    { ta: Term<Jtype<LogicInt>>, tb: Term<Jtype<LogicInt>> -> closure(debug_var_handler,
                                                              open_direct_subtyping,
                                                              query_constr,
                                                              ta, tb) },
    { eta: Term<Jtype<LogicInt>> -> is_correct_type({ ta: Term<Jtype<LogicInt>>, 
                                                    tb: Term<Jtype<LogicInt>> -> 
                                                    closure(debug_var_handler,
                                                    open_direct_subtyping,
                                                    query_constr, ta, tb) },
                                    eta) },
    ta, tb)
  
  
  context(RelationalContext)
  override fun  closure(debug_var_handler: (Term<Jtype<LogicInt>>, Goal, Goal) -> Goal,
        open_direct_subtyping: ((Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal, Term<Jtype<LogicInt>>, Term<Jtype<LogicInt>>, Term<LogicBool>) -> Goal,
        query_constr: Goal, ta: Term<Jtype<LogicInt>>,
        tb: Term<Jtype<LogicInt>>): Goal =
    less_minus_greater(debug_var_handler,
    { ta: Term<Jtype<LogicInt>>, tb: Term<Jtype<LogicInt>> -> direct_subtyping(debug_var_handler,
                                                              open_direct_subtyping,
                                                              query_constr,
                                                              ta, tb) },
    query_constr, ta, tb)
  
  }}
// Put epilogue here 
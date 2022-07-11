//package br.com.zubcovsoft.financas.domain.despesa.repository;
//
//import br.com.zubcovsoft.financas.domain.despesa.model.Despesa;
//import br.com.zubcovsoft.financas.domain.despesa.model.DespesaFiltro;
//import lombok.RequiredArgsConstructor;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DespesaRepositoryImpl implements  DespesaRepositoryQuery {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public List<Despesa> filtrar(DespesaFiltro filtro) {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Despesa> criteria = builder.createQuery(Despesa.class);
//
//        Root<Despesa> root = criteria.from(Despesa.class);
//
//        //Restrições
//        Predicate[] predicates = criarRestricoes(filtro, builder, root);
//        criteria.where(predicates);
//
//
//        TypedQuery<Despesa> query =  entityManager.createQuery(criteria);
//        return query.getResultList();
//    }
//
//    private Predicate[] criarRestricoes(DespesaFiltro filtro, CriteriaBuilder builder, Root<Despesa> root) {
//        List<Predicate> predicates = new ArrayList<>();
//        if(filtro.getValor() != null){
//            predicates.add(builder.equal(root.get("valor"), filtro.getValor()));
//        }
//
//        if(filtro.getDe() != null){
//            predicates.add(
//                    builder.greaterThanOrEqualTo(root.get("data"), filtro.getAte())
//            );
//        }
//
//        if(filtro.getAte() != null){
//            predicates.add(
//                    builder.lessThanOrEqualTo(root.get("data"), filtro.getAte())
//            );
//        }
//
//        return predicates.toArray(new Predicate[predicates.size()]);
//    }
//}

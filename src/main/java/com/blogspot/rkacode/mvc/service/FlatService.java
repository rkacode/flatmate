package com.blogspot.rkacode.mvc.service;


import com.blogspot.rkacode.mvc.dao.FlatRepository;
import com.blogspot.rkacode.mvc.dao.UserRepository;
import com.blogspot.rkacode.mvc.entity.Flat;
import com.blogspot.rkacode.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class FlatService {

    @Autowired
    FlatRepository flatRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionTemplate transactionTemplate;

    public void save(Flat flat) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                flatRepository.save(flat);
            }
        });
    }

    public Flat find(String id) {
        return transactionTemplate.execute(new TransactionCallback<Flat>() {
            @Override
            public Flat doInTransaction(TransactionStatus transactionStatus) {
                return flatRepository.findById(id);
            }
        });
    }

    public void addUser(String flatId, String userId) {
        Flat flat = flatRepository.findById(flatId);
        User user = userRepository.findById(userId);

        flat.addUser(user);
    }

    public Flat findByName(String name) {
        return flatRepository.findByName(name);
    }
}

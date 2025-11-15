package com.varunu28.springjpadomainevent.listener;

import com.varunu28.springjpadomainevent.model.TournamentEndEvent;
import com.varunu28.springjpadomainevent.model.TournamentStartEvent;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TournamentEventListener {

    private static final Logger LOGGER = Logger.getLogger(TournamentEventListener.class.getName());

    // Listening before the transaction commits
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleTournamentEndEvent(TournamentEndEvent event) {
        LOGGER.info("Tournament with ID " + event.tournamentId() + " has ended on " + event.endDate());
    }

    // Using REQUIRES_NEW to ensure this runs in a new transaction after the main transaction commits
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public  void handleTournamentStartEvent(TournamentStartEvent event) {
        LOGGER.info("Tournament with ID " + event.tournamentId() + " has started on " + event.startDate());
    }
}

package ventanas;

import java.util.ArrayList;
import java.util.List;

public class RutaNotificactionService {
	private final RutaObserver observers;

	public RutaNotificactionService(RutaObserver observer) {
		observers = observer;
	}

	public String notifyObserver() {
		return observers.updateRuta();
	}
}

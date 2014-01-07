package com.pksandbox.training.fat.food;

import com.pksandbox.training.core.Notifier;
import com.pksandbox.training.core.Subject;

public interface FoodMonitor extends Subject<FoodUpdate>, Notifier<FoodUpdate> {

}

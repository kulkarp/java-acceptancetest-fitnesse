package com.pksandbox.training.fat.activity;

import com.pksandbox.training.core.Notifier;
import com.pksandbox.training.core.Subject;

public interface ActivityMonitor extends Subject<ActivityUpdate>, Notifier<ActivityUpdate> {

}

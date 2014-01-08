package com.pksandbox.training.user;

import com.pksandbox.training.core.Notifier;
import com.pksandbox.training.core.Subject;

public interface UserSettingsMonitor extends Subject<UserSettingsUpdate>,
		Notifier<UserSettingsUpdate> {

}

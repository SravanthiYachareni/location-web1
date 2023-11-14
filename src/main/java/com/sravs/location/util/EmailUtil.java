package com.sravs.location.util;

import org.eclipse.jdt.internal.compiler.lookup.Scope;

public interface EmailUtil {
    void sendEmail(String toAddress, String subject, String body);
}
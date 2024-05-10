package org.zero.model;

public record FileMeta(
        boolean isExists,
        String path,
        boolean isDirectory,
        boolean isHidden,
        String creationTime,
        String lastModifiedTime,
        String lastAccessTime,
        long size
        ) {
}

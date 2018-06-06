package io.cap;

/**
 * Allow contextual information access.
 */
public interface Contextual
{
    /**
     * Retrieve the context information.
     */
    Context getContext( );

    /**
     * Update the context with the provided
     * context information.
     * @param context information
     */
    void setContext( Context context );
}

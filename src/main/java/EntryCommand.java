import io.quarkus.picocli.runtime.annotations.TopCommand;
import org.gox.command.DateCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {DateCommand.class})
public class EntryCommand {
}

